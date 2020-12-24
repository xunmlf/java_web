package com.person.controller;

import com.person.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XUN~MLF
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName, password;
        int result=0;
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        System.out.println(userName);
        System.out.println(password);
        UserDao dao = new UserDao();
        result=dao.login(userName,password);
        if(result==1){
            response.sendRedirect("/08_web/index.html");
        } else{
            response.sendRedirect("/08_web/again.html");
        }

    }
}
