package JDBC;

import java.sql.*;
import java.util.Scanner;

public class trySort {
    public static void main(String[] args) {

        //用户在控制台控制升降序
        Scanner s=new Scanner(System.in);
        System.out.println("请输入desc/asc desc表示降序 asc表示升序");
        System.out.print("请输入：");
        String keyWords=s.nextLine();

        //执行sql
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            //1:注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2:获取连接
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9","root","ning1026");

            //3:获取数据库对象
            stmt=conn.createStatement();

            //4:执行sql
            String sql=" select id from stus order by id "+keyWords;

            rs=stmt.executeQuery(sql);

            //5:遍历结果集
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(stmt!=null){
                try {
                    stmt.close();
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
