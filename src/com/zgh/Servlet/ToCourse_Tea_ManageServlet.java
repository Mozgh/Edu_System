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
 * Created by feir4 on 2017/5/30.
 */
@WebServlet("/ToCourse_Tea_Manage")
public class ToCourse_Tea_ManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_no=request.getParameter("c_no");
        CourseListBean courselist=new CourseListBean();
        courselist.setCourse_Tea_List(c_no);
        request.setAttribute("courselist",courselist);
        request.setAttribute("c_no",c_no);
        RequestDispatcher rd=request.getRequestDispatcher("/Course_Tea_Manage.jsp");
        rd.forward(request,response);
    }
}
