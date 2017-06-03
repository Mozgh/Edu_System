package com.zgh.Bean;

/**
 * Created by feir4 on 2017/6/3.
 */
public class TeacherEvaluateBean {
    private String te_id;
    private String t_no;
    private String t_name;
    private String c_no;
    private String c_name;
    private int score;
    private String t_comment;

    public TeacherEvaluateBean(){}
    public TeacherEvaluateBean(String te_id,String t_no,String t_name,String c_no,String c_name,int score,String t_comment){
        this.te_id=te_id;this.t_no=t_no;this.t_name=t_name;this.c_no=c_no;this.c_name=c_name;this.score=score;this.t_comment=t_comment;
    }

    public void setTe_id(String te_id){
        this.te_id=te_id;
    }
    public void setT_no(String t_no){
        this.t_no=t_no;
    }
    public void setT_name(String t_name){
        this.t_name=t_name;
    }
    public void setC_no(String c_no){
        this.c_no=c_no;
    }
    public void setC_name(String c_name){
        this.c_name=c_name;
    }
    public void setScore(int score){
        this.score=score;
    }
    public void setT_comment(String t_comment){
        this.t_comment=t_comment;
    }

    public String getTe_id(){return this.te_id;}
    public String getT_no(){return this.t_no;}
    public String getT_name(){return this.t_name;}
    public String getC_no(){return this.c_no;}
    public String getC_name(){return this.c_name;}
    public String getT_comment(){return this.t_comment;}
    public int getScore(){return this.score;}
}
