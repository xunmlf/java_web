package com.person.controller;

import com.person.Dao.QuestionDao;
import com.person.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XUN~MLF
 */
public class QuestionAddServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title, optionA, optionB, optionC, optionD, answer;
        Question question = null;
        QuestionDao dao = new QuestionDao();
        int result = 0;
        // http://localhost:63342/08_web/question/add?title=&optionA=&optionB=&optionC=&optionD=
        // 1:调用请求对象，读取请求头中的信息，得到新增内容
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");

        // 2：调用DAO类
        question = new Question(null,title, optionA, optionB, optionC, optionD, answer);
        result = dao.add(question);
        // 3：通过请求转发，向tomcat索要info.jsp,将处理结果写入到响应体中
        if (result == 1) {
            request.setAttribute("info", "试题添加成功");
        } else {
            request.setAttribute("info", "试题添加失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);

    }
}
