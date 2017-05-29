package com.zgh.Bean;

/**
 * Created by feir4 on 2017/5/25.
 */
public class CourseBean {
    private String c_ID;        //课程ID
    private String c_Name;      //课程名称
    private String c_Depart;    //开课学院
    private String c_Info;      //课程简介
    private String c_Teacher;   //授课教师（名）
    private String c_Site;      //上课地点
    private String c_Time;      //上课时间

    public CourseBean(){}
    public CourseBean(String id,String name,String depart,String info,String teacher,String site,String time){
        this.c_ID=id;
        this.c_Name=name;
        this.c_Depart=depart;
        this.c_Info=info;
        this.c_Teacher=teacher;
        this.c_Site=site;
        this.c_Time=time;
    }

    public void setC_ID(String id){this.c_ID=id;}
    public void setC_Name(String name){this.c_Name=name;}
    public void setC_Depart(String depart){this.c_Depart=depart;}
    public void setC_Info(String info){this.c_Info=info;}
    public void setC_Teacher(String teacher){this.c_Teacher=teacher;}
    public void setC_Site(String site){this.c_Site=site;}
    public void setC_Time(String time){this.c_Time=time;}

    public String getC_ID(){return this.c_ID;}
    public String getC_Name(){return this.c_Name;}
    public String getC_Depart(){return this.c_Depart;}
    public String getC_Info(){return this.c_Info;}
    public String getC_Teacher(){return this.c_Teacher;}
    public String getC_Site(){return this.c_Site;}
    public String getC_Time(){return this.c_Time;}
}
