package com.zgh.Bean;

/**
 * Created by feir4 on 2017/5/25.
 */
public class StudentBean {
    private String s_ID;
    private String s_Name;
    private String s_Sex;
    private int s_Age;
    private String s_Depart;

    public StudentBean(){}
    public StudentBean(String id,String name,String sex,int age,String depart){
        this.s_ID=id;this.s_Name=name;this.s_Sex=sex;this.s_Age=age;
        switch(depart){
            case "10":this.s_Depart="能源与动力工程学院";break;
            case "12":this.s_Depart="光电信息与计算机工程学院";break;
            case "14":this.s_Depart="机械工程学院";break;
            case "16":this.s_Depart="管理学院";break;
            case "18":this.s_Depart="环境与建筑学院";break;
            case "20":this.s_Depart="外语学院";break;
            default:this.s_Depart=depart;break;
        }
    }

    public void setS_ID(String id){this.s_ID=id;}
    public void setS_Name(String name){this.s_Name=name;}
    public void setS_Sex(String sex){this.s_Sex=sex;}
    public void setS_Age(int age){this.s_Age=age;}
    public void setS_Depart(String depart){
        switch(depart){
            case "10":this.s_Depart="能源与动力工程学院";break;
            case "12":this.s_Depart="光电信息与计算机工程学院";break;
            case "14":this.s_Depart="机械工程学院";break;
            case "16":this.s_Depart="管理学院";break;
            case "18":this.s_Depart="环境与建筑学院";break;
            case "20":this.s_Depart="外语学院";break;
            default:this.s_Depart=depart;break;
        }
    }

    public String getS_ID(){return this.s_ID;}
    public String getS_Name(){return this.s_Name;}
    public String getS_Sex(){return this.s_Sex;}
    public int getS_Age(){return this.s_Age;}
    public String getS_Depart(){return this.s_Depart;}

}
