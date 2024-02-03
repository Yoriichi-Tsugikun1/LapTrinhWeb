/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Item;
import model.Order;
import model.OrderLine;
import model.SanPham;
import model.user;

/**
 *
 * @author Admin
 */
public class OrderDAO extends DBContext {

    public int addOrder(user u, Cart cart, String hoten, String diachi, String sdt) {
        if (cart.getTotalMoney() != 0) {
            LocalDate curDate = java.time.LocalDate.now();
            String date = curDate.toString();
            String trangthai = "Đang chờ được duyệt";
            try {
                String sql = "insert into [order] values (?,?,?,?,?,?,?)";
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, u.getAccount());
                st.setString(2, date);
                st.setDouble(3, cart.getTotalMoney());
                st.setString(4, hoten);
                st.setString(5, diachi);
                st.setString(6, sdt);
                st.setString(7, trangthai);
                st.executeUpdate();
                String sql1 = "select top 1 id from [Order] order by id desc";
                PreparedStatement st1 = connection.prepareStatement(sql1);
                ResultSet rs = st1.executeQuery();
                // them vao order line
                if (rs.next()) {
                    int oid = rs.getInt(1);
                    for (Item i : cart.getItems()) {
                        String sql2 = "insert into [OrderLine] values (?,?,?,?)";
                        PreparedStatement st2 = connection.prepareStatement(sql2);
                        st2.setInt(1, oid);
                        st2.setString(2, i.getSanpham().getId());
                        st2.setInt(3, i.getSoluong());
                        st2.setDouble(4, i.getGia());
                        st2.executeUpdate();
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        else {
            return 0;
        }
        return 1;
    }

    public List<Order> getHoaDonByID(String ac) {
        List<Order> list = new ArrayList<>();
        String sql = "select * from [Order] where uid = ? order by id DESC ;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, ac);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8));
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Order> getAllHoaDon() {
        List<Order> list = new ArrayList<>();
        String sql = "select * from [Order] where trangthai = N'Đang chờ được duyệt' order by id;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8));
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void HuyDonHang(int id) {
        String sql = "UPDATE [dbo].[Order]\n"
                + "   SET [trangthai] = N'Đã bị Hủy'\n"
                + " WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int ChapNhanDonHang(int id) {
        OrderLineDAO d = new OrderLineDAO();
        List<OrderLine> list = d.getHoaDonChiTiet(id);
        SanPhamDAO sp = new SanPhamDAO();
        int check = 1;
        for (OrderLine i : list) {
            if (sp.getSanPhamByID(i.getSid()).getSoluong() < i.getSoluong()) {
                check = 0;
            }
        }
        if (check == 1) {
            String sql = "UPDATE [dbo].[Order]\n"
                    + "   SET [trangthai] = N'Đơn Hàng Thành Công'\n"
                    + " WHERE id=?";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, id);
                st.executeUpdate();
                for (OrderLine i : list) {
                    String sql2 = "UPDATE [dbo].[sanpham]\n"
                            + "   SET soluong = ?\n"
                            + " WHERE id = ?;";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, sp.getSanPhamByID(i.getSid()).getSoluong() - i.getSoluong());
                    st2.setString(2, sp.getSanPhamByID(i.getSid()).getId());
                    st2.executeUpdate();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return  check;
    }

    public List<Order> getALLDonHang2(int tinhtrang) {
        List<Order> list = new ArrayList<>();
        String sql = "";
        if(tinhtrang==0){
            sql = sql + "select * from [Order]";
        }
        else if(tinhtrang==1){
            sql = sql + "select * from [Order] where trangthai = N'Đơn Hàng Thành Công'";
        }
        else {
            sql = sql + "select * from [Order] where trangthai = N'Đã bị Hủy'";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8));
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Order> getSoLuong(ArrayList<Order> a,int st , int end){
        List<Order> list = new ArrayList<>();
        for(int i=st;i<end;i++){
            list.add(a.get(i));
        }
        return list;
    }
}
