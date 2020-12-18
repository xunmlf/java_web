package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *  conn.setAutoCommit(false);//开启事务
 *  conn.commit();
 *  conn.rollback();
 */
public class test04 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {

            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9","root","ning1026");

            //将自动提交机制修改为手动提交；
            conn.setAutoCommit(false);//开启事务

            //获取数据库对象
            String sql="update t_act set balance=? where actno=?";
            ps=conn.prepareStatement(sql);

            //给？传值
            ps.setDouble(1,10000);
            ps.setInt(2,111);
            int count =ps.executeUpdate();

            ps.setDouble(1,10000);
            ps.setInt(2,222);
            count +=ps.executeUpdate();

            System.out.println(count==2 ? "转账成功" : "转账失败" );

            //程序执行到这说明没有异常，事务结束，手动提交数据
            conn.commit();


        } catch (Exception e) {
            //回滚事务
            if(conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
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
