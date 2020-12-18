package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class trySum {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            //1：注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2：获取连接
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9","root","ning1026");
            //3:获取数据库操作对象

           // String sql="insert stus values(?,?,?)";  添加操作
           // String sql="delete from stus where id=?";  删除操作
            String sql="update stus set uname=? where id=?";  //修改操作
            ps=conn.prepareStatement(sql);

            ps.setString(1,"ning");
            ps.setInt(2,9);

            int count=ps.executeUpdate();

            //System.out.println(count==1?"添加成功":"添加失败");
            //System.out.println(count==1?"删除成功":"删除失败");
             System.out.println(count==1?"修改成功":"修改失败");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
