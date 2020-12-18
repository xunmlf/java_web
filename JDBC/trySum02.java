package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class trySum02 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement st=null;
        try {
            //1:注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2：获取连接
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9","root","ning1026");
            //3：获取数据库操作对象
            st=conn.createStatement();
            //4：执行SQL
            String sql = "insert stus values(11,'tang',125)";
            int count= st.executeUpdate(sql);
            System.out.println(count==1?"添加成功":"添加失败");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(st!=null){
                try {
                    st.close();
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
