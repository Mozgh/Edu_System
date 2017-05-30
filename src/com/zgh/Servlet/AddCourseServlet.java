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
@WebServlet("/AddCourse")
public class AddCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String depart=request.getParameter("c_depart");
        String c_depart="";
        String c_name=request.getParameter("c_name");
        String c_info=request.getParameter("c_info");
        switch(depart){
            case "10":c_depart="能源与动力工程学院";break;
            case "12":c_depart="光电信息与计算机工程学院";break;
            case "14":c_depart="机械工程学院";break;
            case "16":c_depart="管理学院";break;
            case "18":c_depart="环境与建筑学院";break;
            case "20":c_depart="外语学院";break;
            default:break;
        }

        CourseDao coursedao=new CourseDao();
        String c_no=coursedao.selectCourseNo(Integer.parseInt(depart));
        coursedao.addCourse(c_no,c_name,c_depart,c_info);
        CourseBean course=new CourseBean();
        course.setC_ID(c_no);
        course.setC_Name(c_no);
        course.setC_Info(c_info);
        request.getSession().setAttribute("course",course);
        RequestDispatcher rd=request.getRequestDispatcher("/Course_Add.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
