package com.zgh.Bean;

import com.zgh.Dao.TeacherDao;

import java.util.ArrayList;

/**
 * Created by feir4 on 2017/5/29.
 */
public class TeacherListBean {
    private ArrayList<TeacherBean> teacherList;

    public TeacherListBean(){ this.setTeacherList();}

    public void setTeacherList(){
        TeacherDao teacherdao=new TeacherDao();
        this.teacherList=teacherdao.selectTeachers();
    }
    public ArrayList<TeacherBean> getTeacherList()  {return this.teacherList;}
}
