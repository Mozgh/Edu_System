package com.zgh.Servlet;

import com.zgh.Bean.UserBean;
import com.zgh.Dao.UserDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

/**
 * Created by feir4 on 2017/5/23.
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    String message=null;
    public void init(){

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String true_password=null;
        UserDao userdao=new UserDao();
        UserBean userbean=userdao.findById(id);
        if(password.equals(userbean.getPassword())){
            message="登录成功";
            request.setAttribute("message",message);
            request.getSession().setAttribute("user",userbean);
            if(userbean.getIdentity()==0)
                response.sendRedirect("/ManegeHome.jsp");
            else
                response.sendRedirect("/StudentHome.jsp");
        }
        else{
            message="密码错误";
            request.setAttribute("message",message);
            response.sendRedirect("/index.jsp");
        }
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
