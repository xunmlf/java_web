package JDBC;

import java.sql.*;
import java.util.ResourceBundle;

public class sixTeep02 {
    public static void main(String[] args) {

        //所用资源绑定器绑定属性配置文件
       /* ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
        String driver=bundle.getString("driver");
        String url=bundle.getString("url");
        String user=bundle.getString("user");
        String password=bundle.getString("password");*/



        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            //1:注册驱动：


           // DriverManager.registerDriver(new com.mysql.jdbc.Driver());//注册去驱动的第一种方式
            try {
                Class.forName("com.mysql.jdbc.Driver");//注册驱动的第二种方式
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //2:获取连接：
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode","root","ning1026");

            //3：获取操作对象：
            stmt=conn.createStatement();

            //4:执行sql
            //String sql="delete from t_user where no=4";
            //int count=stmt.executeUpdate(sql);
            //System.out.println(count==1?"删除成功":"删除失败");

            // 返回int executeUpdate  （insert/delete/update）
            // 返回ResultSet   executeQuery (select)

            //4：执行sql
            String sql="select empno,ename,sal from emp";

            rs=stmt.executeQuery(sql);//专门执行DQL语句

            while(rs.next()){//JDBC的下标时从 1 开始
                String empno=rs.getString("empno");
                String ename=rs.getString("ename");
                String sal=rs.getString("sal");
                System.out.println(empno+","+ename+","+sal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            //6：释放资源
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt!=null){
                try {
                    stmt.close();
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
