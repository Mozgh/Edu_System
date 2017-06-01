package com.zgh.Servlet;

import com.zgh.Bean.StudentBean;
import com.zgh.Bean.UserBean;
import com.zgh.Dao.StudentDao;
import com.zgh.Dao.UserDao;

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
@WebServlet("/AddStudent")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("/Stu_Add.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message="";
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String depart=request.getParameter("depart");

        StudentDao studentdao=new StudentDao();
        String id=studentdao.selectStudentNo(Integer.parseInt(age),Integer.parseInt(depart));
        StudentBean studentbean=new StudentBean(id,name,sex,Integer.parseInt(age),depart);
        int result=studentdao.addStudent(studentbean);
        UserDao userdao=new UserDao();
        userdao.addUser(id,id,1);
        if(result==1){
            message="添加成功 学号为："+id;
        }else{
            message="添加失败";
        }
        request.setAttribute("message",message);
        RequestDispatcher rd=request.getRequestDispatcher("/Stu_Manage.jsp");
        rd.forward(request,response);

    }
}
