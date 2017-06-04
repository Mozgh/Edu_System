package com.zgh.Bean;

/**
 * Created by feir4 on 2017/6/4.
 */
public class GradeBean {
    private String s_no;
    private String s_name;
    private String c_no;
    private String c_name;
    private String t_no;
    private int credit;
    private int grade;
    private double GPA;

    public GradeBean(){}
    public GradeBean(String s,String c,String t,int grade){
        this.s_no=s;this.c_no=c;this.t_no=t;this.grade=grade;
    }

    public void setS_no(String s){this.s_no=s;}
    public void setS_name(String sname){this.s_name=sname;}
    public void setC_no(String c){this.c_no=c;}
    public void setC_name(String cname){this.c_name=cname;}
    public void setT_no(String t){this.t_no=t;}
    public void setCredit(int credit){this.credit=credit;}
    public void setGrade(int grade){this.grade=grade;}
    public void setGPA(){
        this.GPA=(this.grade-50)/5*0.5;
        if(this.GPA<0){
            this.GPA=0;
        }
    }

    public String getS_no(){return this.s_no;}
    public String getS_name(){return this.s_name;}
    public String getC_name(){return this.c_name;}
    public String getC_no(){return this.c_no;}
    public String getT_no(){return this.t_no;}
    public int getCredit(){return this.credit;}
    public int getGrade(){return this.grade;}
    public double getGPA(){return this.GPA;}
}
