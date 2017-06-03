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
 * Created by feir4 on 2017/6/2.
 */
@WebServlet("/DelCourseStu")
public class DelCourseStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_no=request.getParameter("s_no");
        String c_no=request.getParameter("c_no");
        String t_no=request.getParameter("t_no");

        CourseDao coursedao=new CourseDao();
        String message=coursedao.delCourseStudent(s_no,c_no,t_no);
        CourseListBean courseStuList= (CourseListBean) request.getSession().getAttribute("courseStuList");
        courseStuList.setCourse_Stu_List(s_no);
        request.setAttribute("message",message);
        request.getSession().setAttribute("courseStuList",courseStuList);
        RequestDispatcher rd=request.getRequestDispatcher("/Course_Stu_Show.jsp");
        rd.forward(request,response);
    }
}
