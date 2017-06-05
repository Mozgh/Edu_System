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

/**
 * Created by feir4 on 2017/6/6.
 */
@WebServlet("/ToQuestion_Page")
public class ToQuestion_PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String q_no=request.getParameter("q_no");
        QuestionDao questiondao=new QuestionDao();
        QuestionBean question=questiondao.selectQuestionByQno(q_no);
        request.setAttribute("question",question);
        questiondao.editq_state(q_no,2);
        RequestDispatcher rd=request.getRequestDispatcher("/Student_QuestionPage.jsp");
        rd.forward(request,response);
    }
}
