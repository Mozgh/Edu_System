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
        this.t_ID=id;this.t_Name=name;this.t_Age=age;this.t_Depart=depart;this.t_Prof=prof;
    }
    //setter
    public void setT_ID(String id){this.t_ID=id;}
    public void setT_Name(String name){this.t_Name=name;}
    public void setT_Age(int age){this.t_Age=age;}
    public void setT_Depart(String depart){this.t_Depart=depart;}
    public void setT_Prof(String prof){this.t_Prof=prof;}
    //getter
    public String getT_ID(){return this.t_ID;}
    public String getT_Name(){return this.t_Name;}
    public int getT_Age(){return this.t_Age;}
    public String getT_Depart(){return this.t_Depart;}
    public String getT_Prof(){return this.t_Prof;}
}
