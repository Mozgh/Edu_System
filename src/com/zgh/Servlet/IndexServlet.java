package com.zgh.Servlet;

import com.zgh.Bean.UserBean;
import com.zgh.Dao.UserDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
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
        String identity=request.getParameter("identity");
        String true_password=null;
        UserDao userdao=new UserDao();
        UserBean userbean=userdao.findById(id,identity);
        RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
        if(password.equals(userbean.getPassword())){
            message="登录成功";
            request.setAttribute("message",message);
            request.getSession().setAttribute("user",userbean);
            switch(userbean.getIdentity()){
                case 0:rd=request.getRequestDispatcher("/ManageHome.jsp");break;
                case 1:rd=request.getRequestDispatcher("/StudentHome.jsp");break;
                case 2:message="暂未开通";break;
                default:message="系统错误";break;
            }
        }
        else{
            message="密码错误";
        }
        request.setAttribute("message",message);
        rd.forward(request,response);
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
