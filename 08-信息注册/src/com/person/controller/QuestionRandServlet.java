package com.person.controller;

import com.person.Dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionRandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 调用Dao 类，
        QuestionDao dao = new QuestionDao();
        List questionList = null;
        HttpSession session =request.getSession();
        questionList=dao.findRand();
        session.setAttribute("key",questionList);
        request.getRequestDispatcher("/exam.jsp").forward(request,response);
    }
}
