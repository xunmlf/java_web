package com.person.controller;

import com.person.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author XUN~MLF
 */
public class PersonDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //2:调用响应体，将处理结果以二进制形式写入到响应体中。
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;

        //1:向请求对象，得到要删除的数据
        Integer userId;
        userId = Integer.parseInt(request.getParameter("userId"));
        System.out.println(userId);
        int count=0;
        UserDao dao= new UserDao();
        count = dao.delete(userId);

        out = response.getWriter();

        if(count==1){
            out.print("<font style='color:red;font-size:40px;'>删除数据成功</font>");
        }else{
            out.print("<font style='color:red;font-size:40px;'>删除数据失败</font>");
        }

    }
}
