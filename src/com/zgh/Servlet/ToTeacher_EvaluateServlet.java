package com.zgh.Servlet;

import com.zgh.Bean.CourseListBean;
import com.zgh.Bean.TeacherEvaluateListBean;
import com.zgh.Dao.TeacherDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by feir4 on 2017/6/3.
 */
@WebServlet("/ToTeacher_Evaluate")
public class ToTeacher_EvaluateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_no=request.getParameter("course");
        String t_no=request.getParameter("t_no");
        TeacherDao teacherdao=new TeacherDao();
        TeacherEvaluateListBean teacherEvaList=new TeacherEvaluateListBean();
        teacherEvaList.setTeacherEvaluateList(t_no,c_no);
        request.setAttribute("teacherEvaList",teacherEvaList);
        RequestDispatcher rd=request.getRequestDispatcher("/Teacher_Evaluate.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_no=request.getParameter("t_no");
        CourseListBean courseList=new CourseListBean();
        courseList.setCourse_List(t_no);
        request.getSession().setAttribute("courseList",courseList);
        RequestDispatcher rd=request.getRequestDispatcher("/Teacher_Evaluate.jsp");
        rd.forward(request,response);
    }
}
