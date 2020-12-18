package JDBC;

import java.sql.*;

/**
 * java连接MySQL数据库 ，执行查找（select） 操作
 */
public class trySelect {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9","root","ning1026");

            String sql="select * from stus ";

            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("uname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
