package com.zgh.Servlet;

import com.zgh.Bean.ClassroomBean;
import com.zgh.Bean.CourseBean;
import com.zgh.Bean.TeacherBean;
import com.zgh.Bean.TeacherListBean;
import com.zgh.Dao.CourseDao;

import javax.print.attribute.standard.RequestingUserName;
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
@WebServlet("/AddCourseTeacher")
public class AddCourseTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_no=request.getParameter("c_no");
        String teacher=request.getParameter("teacher");
        String classroom=request.getParameter("classroom");
        String day=request.getParameter("day");
        String time=request.getParameter("time");

        String message="";
        CourseDao coursedao=new CourseDao();
        int result=coursedao.addCourse_Tea(c_no,teacher,day+time,classroom);
        RequestDispatcher rd=request.getRequestDispatcher("/Course_Tea_Add.jsp");
        if(result!=0){
            message="添加成功";
            rd=request.getRequestDispatcher("/Course_Tea_Manage.jsp");
        }
        else{
            message="添加失败";
        }
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_no=request.getParameter("c_no");
        String depart=String.valueOf(Integer.parseInt(c_no.substring(0,2)));
        switch(depart){
            case "10":depart="能源与动力工程学院";break;
            case "12":depart="光电信息与计算机工程学院";break;
            case "14":depart="机械工程学院";break;
            case "16":depart="管理学院";break;
            case "18":depart="环境与建筑学院";break;
            case "20":depart="外语学院";break;
            default:break;
        }
        CourseDao coursedao=new CourseDao();
        CourseBean course=coursedao.selectByCno(c_no);
        TeacherListBean teacherList=new TeacherListBean();
        teacherList.setTeacherList(depart);
        ArrayList<ClassroomBean> classroomList=coursedao.selectClassroom();
        request.setAttribute("course",course);
        request.setAttribute("teacherList",teacherList);
        request.setAttribute("classroomList",classroomList);
        RequestDispatcher rd=request.getRequestDispatcher("/Course_Tea_Add.jsp");
        rd.forward(request,response);
    }
}
