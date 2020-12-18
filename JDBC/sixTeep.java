package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.DoubleStream;

public class sixTeep {
    public static void main(String[] args) {
        //JDBC编程六步

        /*
           JDBC编程六步
        * 1：注册驱动
        * 2：获取连接
        * 3：获取数据库操作对象（专门执行sql语句的对象）
        * 4：执行sql语句
        * 5：处理查询结果集
        * 6：释放资源
        * */


        Connection conn=null;
        Statement stmt=null;

        try {
            // 1：注册驱动
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            //获取连接
            String url="jdbc:mysql://127.0.0.1:3306/class9";
            String user="root";
            String password="ning1026";
            conn=DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接对象："+conn);

            //3：获取数据库操作对象
            stmt=conn.createStatement();

            //4:执行sql
            String sql="insert into t_user(no,name,sex,birth) values(4,'ning','男','2010-10-26')";
            int count=stmt.executeUpdate(sql);
            System.out.println(count==1? "保存成功" :"保存失败");

            //5:处理查询结果集：

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }

        }
    }
}
