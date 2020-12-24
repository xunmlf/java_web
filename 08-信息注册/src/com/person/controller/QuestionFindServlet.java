package com.person.controller;

import com.person.Dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author XUN~MLF
 */
public class QuestionFindServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionDao dao = new QuestionDao();
        // 1:调用dao
        List list = dao.findAll();

        // 2:   将试题添加到请求作用域对象，作为共享数据
        request.setAttribute("key",list);
        // 3：   请求转发，向tomcat调用questions.jsp将结果与HTML标签写入到响应体
        request.getRequestDispatcher("/questions.jsp").forward(request,response);

    }
}
