package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.user;

public class userDAO extends DBContext {

    public user check(String u, String p) {
        String sql = "SELECT *\n"
                + "  FROM [dbo].[user] where account =? and password =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u);
            st.setString(2, p);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user a = new user(rs.getString("account"), rs.getString("password"), rs.getInt("role"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println("Khong truy xuat thanh cong");
        }
        return null;
    }

    public user getUserbyac(String ac) {
        String sql = "SELECT [account]\n"
                + "      ,[password]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[user] where [account]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, ac);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user u = new user(rs.getString("account"), rs.getString("password"), rs.getInt("role"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println("k connect userDAo");
        }
        return null;
    }

    public void insert(user u) {
        String sql = "INSERT INTO [dbo].[user]\n"
                + "           ([account]\n"
                + "           ,[password]\n"
                + "           ,[role])\n"
                + "     VALUES (?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getAccount());
            st.setString(2, u.getPassword());
            st.setInt(3, u.getRole());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("k insert user");
        }
    }

    public List<user> getALL() {
        String sql = "SELECT * FROM [user]\n"
                + "WHERE account <> 'admin';";
        List<user> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                user u = new user(rs.getString(1), rs.getString(2), rs.getInt(3));
                list.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void updatePassWord(String account) {
        String sql = "UPDATE [dbo].[user]\n"
                + "   SET [password] = '123'\n"
                + "      \n"
                + " WHERE account = ?;";
        try{
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, account);
            st.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
        }
    }
}
