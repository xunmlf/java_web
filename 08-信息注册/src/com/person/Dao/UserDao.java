package com.person.Dao;

import com.person.entity.Users;
import com.person.util.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XUN~MLF
 */
public class UserDao {
    JDBC util = new JDBC();
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public int add(Users users){
        int result=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9?serverTimezone=GMT", "root", "123456");
            String sql="insert into users(userName,password,sex,email) values(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,users.getUserName());
            ps.setString(2, users.getPassword());
            ps.setString(3, users.getSex());
            ps.setString(4,users.getEmail());
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBC.Close(conn,ps,null);
        }
        return result;
    }

    public List find(){
        ArrayList<Users> userList = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9?serverTimezone=GMT", "root", "123456");
            //3：获取操作对象
            String sql = "select * from users";
            ps=conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users users= new Users(userId,userName,password,sex,email);
                userList.add(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBC.Close(conn,ps,null);
        }
        return userList;
    }

    public int delete(int userId){
        int count=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2:获取连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9?serverTimezone=GMT", "root", "123456");
            //3：获取操作对象
            String sql = "delete  from users where userId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.Close(conn, ps, null);
        }
        return count;

    }

    public int login(String userName,String password){
        int result=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2:获取连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9?serverTimezone=GMT", "root", "123456");
            //3：获取操作对象
            String sql = "select * from users where userName=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
               result=1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.Close(conn, ps, rs);
        }
        return result;
    }

}
