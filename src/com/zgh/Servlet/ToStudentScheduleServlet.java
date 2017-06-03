package com.zgh.Servlet;

import com.zgh.Bean.CourseListBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by feir4 on 2017/6/3.
 */
@WebServlet("/ToStudentSchedule")
public class ToStudentScheduleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_no=request.getParameter("s_no");
        CourseListBean courseStuList=new CourseListBean();
        courseStuList.setCourse_Stu_List(s_no);
    }
}
