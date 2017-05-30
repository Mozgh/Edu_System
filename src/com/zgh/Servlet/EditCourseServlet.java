package com.zgh.Servlet;

import com.zgh.Bean.CourseBean;
import com.zgh.Dao.CourseDao;

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
@WebServlet("/EditCourse")
public class EditCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message="";
        String new_info=request.getParameter("new_info");
        String info=request.getParameter("info");
        String c_no=request.getParameter("c_no");
        if(!new_info.equals(info)){
            CourseDao coursedao=new CourseDao();
            int result=coursedao.editCourseInfo(new_info,c_no);
            if(result!=0)
                message="修改成功";
            else
                message="修改失败";
        }
        request.setAttribute("message",message);
        RequestDispatcher rd=request.getRequestDispatcher("/Course_Manage.jsp");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_no=request.getParameter("c_no");
        CourseDao coursedao=new CourseDao();
        CourseBean edit_course=coursedao.selectByCno(c_no);
        request.getSession().setAttribute("edit_course",edit_course);
        RequestDispatcher rd=request.getRequestDispatcher("/Course_Edit.jsp");
        rd.forward(request,response);
    }
}
