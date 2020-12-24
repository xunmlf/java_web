package com.person.controller;

import com.person.Dao.UserDao;
import com.person.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author XUN~MLF
 */
public class PersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //3:调用响应体，将处理结果以二进制形式写入到响应体中。
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=null;
        out=response.getWriter();



        //1:调用请求对象，读取请求头中的参数信息，得到用户的信息
        String userName,password,sex,email;
        UserDao dao=new UserDao();
        Users user = null;
        int result=0;
        userName= request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");

        /**2:调用dao类*/
        user=new Users(null,userName,password,sex,email);
        result= dao.add(user);


        if(result==1){
            out.print("<font style='color:red;font-size:40px'>插入数据成功</font>");
        }else{
            out.print("<font style='color:red;font-size:40px'>插入数据失败</font>");
        }

        /**
         * 判断是否添加成功
         */
        System.out.println(userName);
        System.out.println(password);
        System.out.println(sex);
        System.out.println(email);

    }
}
