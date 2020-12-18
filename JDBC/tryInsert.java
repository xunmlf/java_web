package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Java连接Mysql数据库，执行增加（insert）操作
 */
public class tryInsert {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;

        try {
            //1：注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2：获取连接
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9","root","ning1026") ;
            //3：获取操作对象
            String sql="insert stus values(?,?,?)";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,7);
            ps.setString(2,"曾扬");
            ps.setInt(3,110);
            //4：执行SQL
            int count =ps.executeUpdate();

            ps.setInt(1,8);
            ps.setString(2,"李丽");
            ps.setInt(3,111);
            //4：执行SQL
            count +=ps.executeUpdate();



            System.out.println( count==2 ? "添加成功" : "添加失败" );

            //5：处理查询结果集
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            //6：释放资源
        }
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