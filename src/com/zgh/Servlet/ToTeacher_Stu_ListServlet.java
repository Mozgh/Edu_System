package com.zgh.Servlet;

import com.zgh.Bean.CourseListBean;
import com.zgh.Bean.StudentListBean;
import com.zgh.Dao.CourseDao;
import com.zgh.Dao.StudentDao;

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
@WebServlet("/ToTeacher_Stu_List")
public class ToTeacher_Stu_ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_no=request.getParameter("t_no");
        String c_no=request.getParameter("course");
        String c_name=request.getParameter("c_name");
        StudentDao studentdao=new StudentDao();
        StudentListBean studentList=new StudentListBean();
        studentList.setStudentList(t_no,c_no);
        request.setAttribute("studentList",studentList);
        request.setAttribute("c_name",c_name);
        RequestDispatcher rd=request.getRequestDispatcher("/Teacher_Stu_List.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_no=request.getParameter("t_no");
        CourseDao coursedao=new CourseDao();
        CourseListBean courseList=new CourseListBean();
        courseList.setCourse_List(t_no);
        request.getSession().setAttribute("courseList",courseList);
        request.setAttribute("c_no","");
        request.setAttribute("c_name","");
        RequestDispatcher rd=request.getRequestDispatcher("/Teacher_Stu_List.jsp");
        rd.forward(request,response);
    }
}
