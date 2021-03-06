package com.zgh.Bean;

import com.zgh.Dao.CourseDao;

import java.util.ArrayList;

/**
 * Created by feir4 on 2017/5/30.
 */
public class CourseListBean {
    private ArrayList<CourseBean> course_tea_list;
    private ArrayList<CourseBean> course_list;
    private ArrayList<CourseBean> course_stu_list;

    public CourseListBean(){this.setCourse_List();this.setCourse_Tea_List();}

    public void setCourse_Tea_List(String c_no){
        CourseDao coursedao=new CourseDao();
        this.course_tea_list =coursedao.selectCourseTeacher(c_no,"");
    }
    public void setCourse_Tea_List(){
        CourseDao coursedao=new CourseDao();
        this.course_tea_list=coursedao.selectCourseTeacher("","");
    }
    public void setCourse_List(String t_no){
        CourseDao coursedao=new CourseDao();
        this.course_list=coursedao.selectCourseListByTno(t_no);
    }
    public void setCourse_Stu_List(String s_no){
        CourseDao coursedao=new CourseDao();
        this.course_stu_list=coursedao.selectCourseListBySno(s_no);
    }

    public void setCourse_List(){
        CourseDao coursedao=new CourseDao();
        this.course_list=coursedao.selectCourse();
    }

    public ArrayList<CourseBean> getCourse_Tea_List(){
        return this.course_tea_list;
    }
    public ArrayList<CourseBean> getCourse_List(){return this.course_list;}
    public ArrayList<CourseBean> getCourse_Stu_List(){return this.course_stu_list;}
}
