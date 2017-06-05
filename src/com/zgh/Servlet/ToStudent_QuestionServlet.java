package com.zgh.Servlet;

import com.zgh.Bean.QuestionBean;
import com.zgh.Bean.TeacherBean;
import com.zgh.Dao.QuestionDao;
import com.zgh.Dao.StudentDao;
import com.zgh.Dao.TeacherDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by feir4 on 2017/6/4.
 */
@WebServlet("/ToStudent_Question")
public class ToStudent_QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_no=request.getParameter("t_no");
        String s_no=request.getParameter("s_no");
        String question=request.getParameter("question");
        QuestionDao questiondao=new QuestionDao();
        String q_id=questiondao.selectQuestionID(s_no,t_no);
        String message=questiondao.addQuestion(q_id,s_no,question,t_no);
        request.setAttribute("message",message);
        RequestDispatcher rd=request.getRequestDispatcher("/Student_Question.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_no=request.getParameter("s_no");
        StudentDao studentdao=new StudentDao();
        ArrayList<TeacherBean> teacherList=studentdao.selectTeacherBySno(s_no);
        request.getSession().setAttribute("teacherList",teacherList);
        QuestionDao questiondao=new QuestionDao();
        ArrayList<QuestionBean> question0=questiondao.selectQuestionsAnswered(s_no,0);  //未被回答问题列表
        ArrayList<QuestionBean> question1=questiondao.selectQuestionsAnswered(s_no,1);  //已被回答问题列表
        ArrayList<QuestionBean> question2=questiondao.selectQuestionsAnswered(s_no,2);  //未被查看过问题列表
        request.getSession().setAttribute("question0",question0);
        request.getSession().setAttribute("question1",question1);
        request.getSession().setAttribute("question2",question2);
        RequestDispatcher rd=request.getRequestDispatcher("/Student_Question.jsp");
        rd.forward(request,response);
    }
}
