package com.zgh.Servlet;

import com.zgh.Bean.CourseListBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by feir4 on 2017/6/2.
 */
@WebServlet("/ToCourse_Stu_Show")
public class ToCourse_Stu_ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_no=request.getParameter("s_no");
        CourseListBean courseList=new CourseListBean();
        courseList.setCourse_Stu_List(s_no);
        request.setAttribute("courseStuList",courseList);
        RequestDispatcher rd=request.getRequestDispatcher("/Course_Stu_Show.jsp");
        rd.forward(request,response);
    }
}
