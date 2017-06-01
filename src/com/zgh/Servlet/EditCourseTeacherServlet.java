package com.zgh.Servlet;

import com.zgh.Bean.CourseBean;
import com.zgh.Bean.CourseListBean;
import com.zgh.Dao.CourseDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by feir4 on 2017/5/30.
 */
@WebServlet("/EditCourseTeacher")
public class EditCourseTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String old_time=request.getParameter("old_time");
        String new_time=request.getParameter("day")+request.getParameter("time");
        String old_room=request.getParameter("room");
        String new_room=request.getParameter("new_room");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ct_id=request.getParameter("ct_id");
        CourseDao coursedao=new CourseDao();
        CourseBean edit_course=coursedao.selectCourseTeacher(ct_id);
        request.setAttribute("edit_course",edit_course);
        RequestDispatcher rd=request.getRequestDispatcher("/Course_Tea_Edit.jsp");
        rd.forward(request,response);
    }
}
