package com.zgh.Bean;

/**
 * Created by feir4 on 2017/5/25.
 */
public class TeacherBean {
    private String t_ID;
    private String t_Name;
    private int t_Age;
    private String t_Depart;
    private String t_Prof;

    public TeacherBean(){}
    public TeacherBean(String id,String name,int age,String depart,String prof){
        this.t_ID=id;this.t_Name=name;this.t_Age=age;
        switch(depart){
            case "10":this.t_Depart="能源与动力工程学院";break;
            case "12":this.t_Depart="光电信息与计算机工程学院";break;
            case "14":this.t_Depart="机械工程学院";break;
            case "16":this.t_Depart="管理学院";break;
            case "18":this.t_Depart="环境与建筑学院";break;
            case "20":this.t_Depart="外语学院";break;
            default:this.t_Depart=depart;break;
        }
        this.t_Prof=prof;
    }
    //setter
    public void setT_ID(String id){this.t_ID=id;}
    public void setT_Name(String name){this.t_Name=name;}
    public void setT_Age(int age){this.t_Age=age;}
    public void setT_Depart(String depart){
        switch(depart){
            case "10":this.t_Depart="能源与动力工程学院";break;
            case "12":this.t_Depart="光电信息与计算机工程学院";break;
            case "14":this.t_Depart="机械工程学院";break;
            case "16":this.t_Depart="管理学院";break;
            case "18":this.t_Depart="环境与建筑学院";break;
            case "20":this.t_Depart="外语学院";break;
            default:this.t_Depart=depart;break;
        }
    }
    public void setT_Prof(String prof){this.t_Prof=prof;}
    //getter
    public String getT_ID(){return this.t_ID;}
    public String getT_Name(){return this.t_Name;}
    public int getT_Age(){return this.t_Age;}
    public String getT_Depart(){return this.t_Depart;}
    public String getT_Prof(){return this.t_Prof;}
}
