package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * java连接MySQL数据库 ，执行修改（update）操作
 */
public class tryUpdate {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9","root","ning1026");
            //获取操作对象
            String sql="update stus set id=? where no=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,9);
            ps.setInt(2,110);
            int count =ps.executeUpdate();
            System.out.println( count==1 ? "修改成功" : "修改失败" );

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6:释放资源
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
