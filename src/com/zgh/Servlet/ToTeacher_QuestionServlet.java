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
@WebServlet("/ToTeacher_Question")
public class ToTeacher_QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_no=request.getParameter("t_no");
        QuestionDao questiondao=new QuestionDao();
        ArrayList<QuestionBean> question0=questiondao.selectQuestionsAsked(t_no);
        request.getSession().setAttribute("question0",question0);
        RequestDispatcher rd=request.getRequestDispatcher("/Teacher_Question.jsp");
        rd.forward(request,response);
    }
}
