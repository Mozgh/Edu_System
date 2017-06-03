package com.zgh.Servlet;

import com.zgh.Bean.TeacherEvaluateBean;
import com.zgh.Bean.TeacherEvaluateListBean;
import com.zgh.Dao.TeacherDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by feir4 on 2017/6/3.
 */
@WebServlet("/ToStudentEvaluate")
public class ToStudentEvaluateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_no=request.getParameter("s_no");
        String t_no=request.getParameter("t_no");
        String c_no=request.getParameter("c_no");
        int score=Integer.parseInt(request.getParameter("score"));
        String comment=request.getParameter("comment");
        TeacherDao teacherdao=new TeacherDao();
        String te_id=teacherdao.selectTEID(t_no,c_no);
        teacherdao.addTeacherEvaluate(te_id,t_no,c_no,score,comment);
        TeacherEvaluateListBean teacherEvaList= (TeacherEvaluateListBean) request.getSession().getAttribute("teacherEvaList");
        teacherEvaList.getTeacherEvaluateList().remove(0);
        request.getSession().setAttribute("teacherEvaList",teacherEvaList);
        RequestDispatcher rd=request.getRequestDispatcher("/StudentHome.jsp");
        if(teacherEvaList.getTeacherEvaluateList().size()!=0){
            TeacherEvaluateBean teacherEva=teacherEvaList.getTeacherEvaluateList().get(0);
            request.setAttribute("teacherEva",teacherEva);
            rd=request.getRequestDispatcher("/Student_Evaluate.jsp");
        }
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_no=request.getParameter("s_no");
        TeacherEvaluateListBean teacherEvaList=new TeacherEvaluateListBean();
        TeacherDao teacherdao=new TeacherDao();
        teacherEvaList.setTeacherEvaluateList(s_no);
        request.getSession().setAttribute("teacherEvaList",teacherEvaList);
        TeacherEvaluateBean teacherEva=teacherEvaList.getTeacherEvaluateList().get(0);
        request.setAttribute("teacherEva",teacherEva);
        RequestDispatcher rd=request.getRequestDispatcher("/Student_Evaluate.jsp");
        rd.forward(request,response);
    }
}
