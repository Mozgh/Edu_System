package com.zgh.Bean;

/**
 * Created by feir4 on 2017/5/25.
 */
public class CourseBean {
    private String ct_ID;
    private String c_ID;        //课程ID
    private String c_Name;      //课程名称
    private String c_Depart;    //开课学院
    private String c_Info;      //课程简介
    private int c_Credit;    //课程学分
    private String t_ID;
    private String c_Teacher;   //授课教师（名）
    private String c_Room;      //上课地点
    private String c_Time;      //上课时间

    public CourseBean(){}
    public CourseBean(String ct_ID,String id,String name,String depart,String info,int credit,String teacher,String site,String time){
        this.ct_ID=ct_ID;
        this.c_ID=id;
        this.c_Name=name;
        switch(depart){
            case "10":this.c_Depart="能源与动力工程学院";break;
            case "12":this.c_Depart="光电信息与计算机工程学院";break;
            case "14":this.c_Depart="机械工程学院";break;
            case "16":this.c_Depart="管理学院";break;
            case "18":this.c_Depart="环境与建筑学院";break;
            case "20":this.c_Depart="外语学院";break;
            default:this.c_Depart=depart;break;
        }
        this.c_Info=info;
        this.c_Credit=credit;
        this.c_Teacher=teacher;
        this.c_Room =site;
        this.c_Time=time;
    }

    public void setCT_ID(String ct_id){this.ct_ID=ct_id;}
    public void setC_ID(String id){this.c_ID=id;}
    public void setC_Name(String name){this.c_Name=name;}
    public void setC_Depart(String depart){
        switch(depart){
            case "10":this.c_Depart="能源与动力工程学院";break;
            case "12":this.c_Depart="光电信息与计算机工程学院";break;
            case "14":this.c_Depart="机械工程学院";break;
            case "16":this.c_Depart="管理学院";break;
            case "18":this.c_Depart="环境与建筑学院";break;
            case "20":this.c_Depart="外语学院";break;
            default:this.c_Depart=depart;break;
        }
    }
    public void setC_Info(String info){this.c_Info=info;}
    public void setC_Credit(int credit){this.c_Credit =credit;}
    public void setT_ID(String t_no){this.t_ID=t_no;}
    public void setC_Teacher(String teacher){this.c_Teacher=teacher;}
    public void setC_Room(String site){this.c_Room =site;}
    public void setC_Time(String time){this.c_Time=time;}

    public String getCT_ID(){return this.ct_ID;}
    public String getC_ID(){return this.c_ID;}
    public String getC_Name(){return this.c_Name;}
    public String getC_Depart(){return this.c_Depart;}
    public String getC_Info(){return this.c_Info;}
    public int getC_Credit(){return this.c_Credit;}
    public String getT_ID(){return this.t_ID;}
    public String getC_Teacher(){return this.c_Teacher;}
    public String getC_Room(){return this.c_Room;}
    public String getC_Time(){return this.c_Time;}
}
