package com.zgh.Servlet;

import com.zgh.Bean.StudentBean;
import com.zgh.Bean.UserBean;
import com.zgh.Dao.CourseDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by feir4 on 2017/5/31.
 */
@WebServlet("/AddCourseStudent")
public class AddCourseStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_no=request.getParameter("c_no");
        String t_no=request.getParameter("t_no");
        String c_time=request.getParameter("c_time");
        String ct_id=request.getParameter("ct_id");
        UserBean student= (UserBean) request.getSession().getAttribute("user");
        String s_no=student.getId();
        String message="";
        CourseDao coursedao=new CourseDao();
        message=coursedao.addCourseStudent(ct_id,c_time,s_no,c_no,t_no);
        request.setAttribute("message",message);
        RequestDispatcher rd=request.getRequestDispatcher("/Course_Stu_Add.jsp");
        rd.forward(request,response);
    }
}
