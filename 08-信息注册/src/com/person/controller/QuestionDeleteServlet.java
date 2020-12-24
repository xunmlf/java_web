package com.person.controller;

import com.person.Dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XUN~MLF
 */
public class QuestionDeleteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int questionId;
        int result = 0;
        String temp = request.getParameter("questionId");
        questionId = Integer.parseInt(temp);

        System.out.println(questionId);

        QuestionDao dao = new QuestionDao();

        result = dao.deleteQuestion(questionId);

        if (result == 1) {
            request.setAttribute("de", "试题删除成功");
        } else {
            request.setAttribute("de", "试题删除失败");
        }

        request.getRequestDispatcher("/de.jsp").forward(request, response);
    }
}
