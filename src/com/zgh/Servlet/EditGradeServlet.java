package com.zgh.Servlet;

import com.zgh.Bean.GradeBean;
import com.zgh.Dao.TeacherDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by feir4 on 2017/6/4.
 */
@WebServlet("/EnterGrade")
public class EditGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count=Integer.parseInt(request.getParameter("count"));
        ArrayList<String> grade=new ArrayList<String>();
        for(int i=0;i<count;i++){
            String g="grade"+String.valueOf(i+1);
            grade.add(request.getParameter(g));
        }
        TeacherDao teacherdao=new TeacherDao();
        ArrayList<GradeBean> gradeList= (ArrayList<GradeBean>) request.getSession().getAttribute("gradeList");
        int result=teacherdao.addGrade(gradeList,grade);
        request.setAttribute("row",result);
        request.getSession().removeAttribute("gradeList");
        RequestDispatcher rd=request.getRequestDispatcher("/Teacher_EnterGrade.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
