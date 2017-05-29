package com.zgh.Bean;

import com.zgh.Dao.StudentDao;

import java.util.ArrayList;

/**
 * Created by feir4 on 2017/5/25.
 */
public class StudentListBean {
    private ArrayList<StudentBean> studentList;

    public StudentListBean(){this.setStudentList();}

    public void setStudentList(){
        StudentDao studentdao=new StudentDao();
        this.studentList=studentdao.selectStudents();
    }
    public ArrayList<StudentBean> getStudentList(){return this.studentList;}
}
