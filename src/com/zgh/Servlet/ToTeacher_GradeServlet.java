package com.zgh.Servlet;

import com.zgh.Bean.CourseListBean;
import com.zgh.Bean.GradeListBean;
import com.zgh.Dao.TeacherDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by feir4 on 2017/6/4.
 */
@WebServlet("/ToTeacher_Grade")
public class ToTeacher_GradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_no=request.getParameter("t_no");
        String c_no=request.getParameter("course");
        TeacherDao teacherdao=new TeacherDao();
        GradeListBean gradeList=new GradeListBean();
        gradeList.setGradeList(c_no,t_no);
        request.getSession().setAttribute("gradeList",gradeList.getGradeList());
        RequestDispatcher rd=request.getRequestDispatcher("/Teacher_EnterGrade.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_no=request.getParameter("t_no");
        CourseListBean courseList=new CourseListBean();
        courseList.setCourse_List(t_no);
        request.getSession().setAttribute("courseList",courseList);
        RequestDispatcher rd=request.getRequestDispatcher("/Teacher_EnterGrade.jsp");
        rd.forward(request,response);
    }
}
