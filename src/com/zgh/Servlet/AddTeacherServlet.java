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
@WebServlet("/AddTeacher")
public class AddTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("/Tea_Add.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message="";
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        String depart=request.getParameter("depart");
        String prof=request.getParameter("prof");

        TeacherDao teacherdao=new TeacherDao();
        String id=teacherdao.selectTeacherNo(Integer.parseInt(depart));
        TeacherBean teacher=new TeacherBean(id,name,Integer.parseInt(age),depart,prof);
        int result=teacherdao.addTeacher(teacher);
        if(result==1){
            message="添加成功，教工号为："+id;
        }
        else{
            message="添加失败";
        }
        request.setAttribute("message",message);
        RequestDispatcher rd=request.getRequestDispatcher("/Tea_Manage.jsp");
        rd.forward(request,response);
    }
}
