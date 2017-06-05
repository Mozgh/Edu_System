package com.zgh.Servlet;

import com.zgh.Bean.QuestionBean;
import com.zgh.Dao.QuestionDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by feir4 on 2017/6/6.
 */
@WebServlet("/AnswerQuestionPage")
public class AnswerQuestionPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_no=request.getParameter("t_no");
        String answer=request.getParameter("answer");
        String q_no=request.getParameter("q_no");
        QuestionDao questiondao=new QuestionDao();
        String message=questiondao.addAnswer(t_no,q_no,answer);
        request.setAttribute("message",message);
        ArrayList<QuestionBean> question0=questiondao.selectQuestionsAsked(t_no);
        request.getSession().setAttribute("question0",question0);
        RequestDispatcher rd=request.getRequestDispatcher("/Teacher_Question.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_no=request.getParameter("t_no");
        String q_no=request.getParameter("q_no");
        QuestionDao questiondao=new QuestionDao();
        QuestionBean question=questiondao.selectQuestionByQno(q_no);
        request.setAttribute("question",question);
        RequestDispatcher rd=request.getRequestDispatcher("/Teacher_AnswerPage.jsp");
        rd.forward(request,response);
    }
}
