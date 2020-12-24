package com.person.controller;

import com.person.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author XUN~MLF
 */
public class ExamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession(false);
        List<Question> list = null;
        list= (List)session.getAttribute("key");

        int score=0;

        for(Question question:list){
            String answer = question.getAnswer();
            Integer questionId = question.getQuestionId();
            String userAnswer = request.getParameter("answer_"+questionId);
            if(userAnswer.equals(answer)){
                score+=25;
            }
        }
        request.setAttribute("info","本次考试的成绩为:"+score);
        request.getRequestDispatcher("/info.jsp").forward(request,response);

    }
}
