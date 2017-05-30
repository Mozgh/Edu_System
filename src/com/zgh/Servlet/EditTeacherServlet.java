package com.zgh.Servlet;

import com.zgh.Bean.TeacherBean;
import com.zgh.Dao.TeacherDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by feir4 on 2017/5/29.
 */
@WebServlet("/EditTeacher")
public class EditTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_id=request.getParameter("t_id");
        TeacherDao teacherdao=new TeacherDao();
        TeacherBean teacher=teacherdao.selectById(t_id);
        request.getSession().setAttribute("edit_teacher",teacher);
        RequestDispatcher rd=request.getRequestDispatcher("/Tea_Edit.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message="";
        String t_id=request.getParameter("t_id");
        String new_name=request.getParameter("new_name");
        String new_depart=request.getParameter("new_depart");
        String new_prof=request.getParameter("new_prof");
        String name=request.getParameter("name");
        String depart=request.getParameter("depart");
        String prof=request.getParameter("prof");
        TeacherDao teacherdao=new TeacherDao();
        if(new_name==""){
            new_name=name;
        }
        if(new_depart==""){
            new_depart=depart;
        }
        if(new_prof==""){
            new_prof=prof;
        }
        RequestDispatcher rd=request.getRequestDispatcher("/Tea_Edit.jsp");
        int result=teacherdao.updateTeacher(t_id,new_name,new_depart,new_prof);
        if(result!=0){
            message="修改成功";
            rd=request.getRequestDispatcher("/Tea_Manage.jsp");
            rd.forward(request,response);
            return;
        }else{
            message="修改失败";
        }
        request.setAttribute("message",message);
        rd.forward(request,response);
    }
}
