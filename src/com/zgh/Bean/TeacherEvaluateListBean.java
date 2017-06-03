package com.zgh.Bean;

import com.zgh.Dao.TeacherDao;

import java.util.ArrayList;

/**
 * Created by feir4 on 2017/6/3.
 */
public class TeacherEvaluateListBean {
    private ArrayList<TeacherEvaluateBean> teacherEvaluateList;

    public TeacherEvaluateListBean(){}

    public void setTeacherEvaluateList(String s_no){
        TeacherDao teacherdao=new TeacherDao();
        this.teacherEvaluateList=teacherdao.selectTeacherListBySno(s_no);
    }
    public ArrayList<TeacherEvaluateBean> getTeacherEvaluateList(){return this.teacherEvaluateList;}
}
