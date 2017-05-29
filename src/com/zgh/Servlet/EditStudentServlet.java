package com.zgh.Servlet;

import com.zgh.Bean.StudentBean;
import com.zgh.Dao.StudentDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by feir4 on 2017/5/28.
 */
@WebServlet("/EditStudent")
public class EditStudentServlet extends HttpServlet {
    String message;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_id=request.getParameter("s_id");
        StudentDao studentdao=new StudentDao();
        StudentBean student=studentdao.selectByID(s_id);
        request.getSession().setAttribute("edit_student",student);
        RequestDispatcher rd=request.getRequestDispatcher("/Stu_Edit.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
            String s_id=request.getParameter("s_id");
//            String new_name=new String(request.getParameter("new_name").getBytes("iso-8859-1"),"utf-8");
//            String new_depart=new String(request.getParameter("new_depart").getBytes("iso-8859-1"),"utf-8");
//            String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
//            String depart=new String(request.getParameter("depart").getBytes("iso-8859-1"),"utf-8");
            String new_name=request.getParameter("new_name");
            String new_depart=request.getParameter("new_depart");
            String name=request.getParameter("name");
            String depart=request.getParameter("depart");
            StudentDao studentdao=new StudentDao();
            if(new_name==""){
            new_name=name;
        }
        if(new_depart==""){
            new_depart=depart;
        }
        int result=studentdao.updateStudent(s_id,new_name,new_depart);
        RequestDispatcher rd=request.getRequestDispatcher("/Stu_Edit.jsp");
        if(result!=0){
            message="修改成功";
            rd=request.getRequestDispatcher("/Stu_Manage.jsp");
            rd.forward(request,response);
            return;
        }else{
            message="修改失败";
        }
        request.setAttribute("message",message);
        rd.forward(request,response);
    }
}
