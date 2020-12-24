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
public class QuestionFindByIdServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int questionId;
        String temp=request.getParameter("questionId");
        questionId= Integer.parseInt(temp);
        QuestionDao dao = new QuestionDao();

        Question question=null;
        question=dao.findById(questionId);

        // 将信息写入到响应体
        request.setAttribute("key",question);
        request.getRequestDispatcher("/question_update.jsp").forward(request,response);
    }
}
