package com.zgh.Servlet;

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
@WebServlet("/DelTeacher")
public class DelTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message="";
        String t_id=request.getParameter("t_id");
        TeacherDao teacherdao=new TeacherDao();
        int result=teacherdao.delTeacher(t_id);
        if(result!=0){
            message="删除成功";
        }
        else{
            message="删除失败";
        }
        request.setAttribute("message",message);
        RequestDispatcher rd=request.getRequestDispatcher("/Tea_Manage.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
