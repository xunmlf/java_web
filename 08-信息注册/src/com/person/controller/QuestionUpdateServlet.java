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
public class QuestionUpdateServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title, optionA, optionB, optionC, optionD, answer;
        int questionId;
        QuestionDao dao = new QuestionDao();
        Question question=null;
        int result = 0;

        String temp=request.getParameter("questionId");
        questionId=Integer.parseInt(temp);
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");

        question = new Question(questionId,title, optionA, optionB, optionC, optionD, answer);
        result = dao.update(question);

        // 3：通过请求转发，向tomcat索要info.jsp,将处理结果写入到响应体中
        if (result == 1) {
            request.setAttribute("info", "试题更新成功");
        } else {
            request.setAttribute("info", "试题更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
