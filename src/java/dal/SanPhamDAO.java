/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.SanPham;

//create table sanpham(
//	[id] [varchar](5) primary key,
//	[tensp] [nvarchar](255),
//	[manhinh] [nvarchar](255),
//	[cpu] [nvarchar](255),
//	[ram] [nvarchar](100),
//	[ocung] [nvarchar](100),
//	[dohoa] [nvarchar](255),
//	[hdh] [nvarchar](255),
//	[trongluong] [varchar](4),
//	[kichthuoc] [varchar] (50),
//	[xuatxu] [nvarchar](255),
//	[nam] [int],
//	[giaban] [float],
//	[soluong] [int],
//	[loai] [nvarchar] (100),
//	[hang] [varchar](10),
//	[img1] [varchar](20),
//	[img2] [varchar](20),
//	[img3] [varchar](20),
//);
public class SanPhamDAO extends DBContext {

    public List<Map<String, Object>> getALL() {
        List<Map<String, Object>> list = new ArrayList<>();
        String sql = "select top 4 id,tensp,giaban,soluong,img1 from sanpham ";
        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("tensp", rs.getString("tensp"));
                map.put("giaban", rs.getDouble("giaban"));
                map.put("soluong", rs.getInt("soluong"));
                map.put("img1", rs.getString("img1"));
                list.add(map);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public SanPham getSanPhamByID(String id) {
        String sql = "select * from sanpham where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getInt(12), rs.getDouble(13), rs.getInt(14), rs.getString(15), rs.getString(16), rs.getString(17),
                        rs.getString(18), rs.getString(19));
            }
        } catch (SQLException e) {
            System.out.println("Loi");
        }
        return null;
    }

    public List<Map<String, Object>> getSanPhamByName(String name) {
        List<Map<String, Object>> list = new ArrayList<>();
        String sql = "select id,tensp,giaban,soluong,img1 from sanpham where hang = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("tensp", rs.getString("tensp"));
                map.put("giaban", rs.getDouble("giaban"));
                map.put("soluong", rs.getInt("soluong"));
                map.put("img1", rs.getString("img1"));
                list.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Loi");
        }
        return list;
    }

    public List<Map<String, Object>> getSanPhamByNameSP(String name) {
        List<Map<String, Object>> list = new ArrayList<>();
        String sql = "select id,tensp,giaban,soluong,img1 from sanpham where tensp LIKE ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("tensp", rs.getString("tensp"));
                map.put("giaban", rs.getDouble("giaban"));
                map.put("soluong", rs.getInt("soluong"));
                map.put("img1", rs.getString("img1"));
                list.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Loi");
        }
        return list;
    }

    public int getSoLuongSanPham() {
        int sl = 0;
        String sql = "select top 1 id from sanpham ORDER BY id DESC;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String kq = rs.getString(1);
                sl = Integer.parseInt(kq.substring(kq.length() - 3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sl;
    }

    public void insertSanPham(SanPham a) {
        String sql = "insert into sanpham values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getId());
            st.setString(2, a.getTensp());
            st.setString(3, a.getManhinh());
            st.setString(4, a.getCpu());
            st.setString(5, a.getRam());
            st.setString(6, a.getOcung());
            st.setString(7, a.getDohoa());
            st.setString(8, a.getHdh());
            st.setString(9, a.getTrongluong());
            st.setString(10, a.getKichthuoc());
            st.setString(11, a.getXuatxu());
            st.setInt(12, a.getNam());
            st.setDouble(13, a.getGiaban());
            st.setInt(14, a.getSoluong());
            st.setString(15, a.getLoai());
            st.setString(16, a.getHang());
            st.setString(17, a.getImg1());
            st.setString(18, a.getImg2());
            st.setString(19, a.getImg3());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateSanPham(SanPham a) {
        String sql = "UPDATE [dbo].[sanpham]\n"
                + "SET tensp=?, manhinh=?, cpu=?, ram=?, ocung=?, dohoa=?, hdh=?, trongluong=?, kichthuoc=?, xuatxu=?, nam=?, giaban=?, soluong=?, loai=?, hang=?, img1=?, img2=?, img3=?\n"
                + "WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getTensp());
            st.setString(2, a.getManhinh());
            st.setString(3, a.getCpu());
            st.setString(4, a.getRam());
            st.setString(5, a.getOcung());
            st.setString(6, a.getDohoa());
            st.setString(7, a.getHdh());
            st.setString(8, a.getTrongluong());
            st.setString(9, a.getKichthuoc());
            st.setString(10, a.getXuatxu());
            st.setInt(11, a.getNam());
            st.setDouble(12, a.getGiaban());
            st.setInt(13, a.getSoluong());
            st.setString(14, a.getLoai());
            st.setString(15, a.getHang());
            st.setString(16, a.getImg1());
            st.setString(17, a.getImg2());
            st.setString(18, a.getImg3());
            st.setString(19, a.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int Delete(String id) {
        String sql = "DELETE FROM [dbo].[sanpham]\n"
                + "      WHERE id=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            int d = st.executeUpdate();
            if(d>0){
                return  1;
            }
            
        } catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }
    public List<Map<String, Object>> getLapTopVanPhong() {
        List<Map<String, Object>> list = new ArrayList<>();
        String sql = "select top 4 id,tensp,giaban,soluong,img1 from sanpham where loai = N'Văn phòng'";
        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("tensp", rs.getString("tensp"));
                map.put("giaban", rs.getDouble("giaban"));
                map.put("soluong", rs.getInt("soluong"));
                map.put("img1", rs.getString("img1"));
                list.add(map);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public List<Map<String, Object>> getLapTopGamming() {
        List<Map<String, Object>> list = new ArrayList<>();
        String sql = "select top 4 id,tensp,giaban,soluong,img1 from sanpham where loai = N'Gamming'";
        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("tensp", rs.getString("tensp"));
                map.put("giaban", rs.getDouble("giaban"));
                map.put("soluong", rs.getInt("soluong"));
                map.put("img1", rs.getString("img1"));
                list.add(map);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
