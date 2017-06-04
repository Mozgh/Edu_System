package com.zgh.Servlet;

import com.sun.tools.internal.ws.processor.model.Request;
import com.zgh.Bean.GradeBean;
import com.zgh.Bean.GradeListBean;
import com.zgh.Dao.StudentDao;

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
@WebServlet("/ToStudent_Grade")
public class ToStudent_GradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_no=request.getParameter("s_no");
        StudentDao studentdao=new StudentDao();
        ArrayList<GradeBean> gradeList=studentdao.selectGradeBySno(s_no);
        double ave_GPA=0;
        double sum_GPA=0;
        int sum_Credit=0;
        for(int i=0;i<gradeList.size();i++){
            sum_GPA+=gradeList.get(i).getGPA()*gradeList.get(i).getCredit();
            sum_Credit+=gradeList.get(i).getCredit();
        }
        ave_GPA=sum_GPA/sum_Credit;
        request.getSession().setAttribute("ave_GPA",String.valueOf(ave_GPA));
        request.getSession().setAttribute("gradeList",gradeList);
        RequestDispatcher rd=request.getRequestDispatcher("/Student_Grade.jsp");
        rd.forward(request,response);
    }
}
