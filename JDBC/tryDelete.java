package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * java连接MySQL数据库，执行 删除（delete） 操作
 */
public class tryDelete {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;


        try {
            //1:注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2：获取连接
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9","root","ning1026");

            //3:获取数据库对象
            String sql="delete from stus where id=?";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,8);
            //4：执行sql
            int count = ps.executeUpdate();
            System.out.println( count==1 ? "删除成功" : "删除失败");
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
