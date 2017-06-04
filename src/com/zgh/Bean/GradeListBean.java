package com.zgh.Bean;

import com.zgh.Dao.TeacherDao;

import java.util.ArrayList;

/**
 * Created by feir4 on 2017/6/4.
 */
public class GradeListBean {
    private ArrayList<GradeBean> gradeList;

    public GradeListBean(){}

    public void setGradeList(String c_no,String t_no){
        TeacherDao teacherdao=new TeacherDao();
        this.gradeList=teacherdao.selectStudentByTnoCno(c_no,t_no);
    }

    public ArrayList<GradeBean> getGradeList(){return this.gradeList;}
}
