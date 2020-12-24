package com.person.controller;

import com.person.Dao.UserDao;
import com.person.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author XUN~MLF
 */
public class PersonFindServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //2:调用响应体，将处理结果以二进制形式写入到响应体中。
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=null;
        out=response.getWriter();
        //1:从数据库中查找数据
        UserDao dao=new UserDao();
        List<Users> userList = dao.find();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>用户ID</td>");
        out.print("<td>用户姓名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户邮箱 </td>");
        out.print("<td>操作 </td>");
        out.print("</tr>");
        for (Users users: userList){
            out.print("<tr>");
            out.print("<td>"+users.getUserId()+"</td>");
            out.print("<td>"+users.getUserName()+"</td>");
            out.print("<td>"+users.getPassword()+"</td>");
            out.print("<td>"+users.getSex()+"</td>");
            out.print("<td>"+users.getEmail()+"</td>");
            out.print("<td><a href='/08_web/delete?userId="+users.getUserId()+"'>删除用户</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");

    }
}
