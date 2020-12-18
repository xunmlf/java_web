package JDBC;

import java.sql.*;
import java.util.Scanner;

public class test03 {
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
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //获取连接
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode","root","ning1026");

            //获取数据库对象
            stmt=conn.createStatement();

            //执行sql
            String sql=" select ename from emp order by ename "+keyWords;

            rs=stmt.executeQuery(sql);

            //遍历结果集
            while (rs.next()) {
                System.out.println(rs.getString("ename"));
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
