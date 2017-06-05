package com.zgh.Bean;

/**
 * Created by feir4 on 2017/6/4.
 */
public class QuestionBean {
    private String q_no;
    private String s_no;
    private String s_name;
    private String t_no;
    private String t_name;
    private String question;
    private String answer;
    private int q_state;

    public QuestionBean(){}
    public QuestionBean(String q_no,String s_no,String s_name,String t_no,String t_name,String question,String answer,int q_state){
        this.q_no=q_no;
        this.s_no=s_no;
        this.s_name=s_name;
        this.t_no=t_no;
        this.t_name=t_name;
        this.question=question;
        this.answer =answer;
        this.q_state=q_state;
    }

    public void setQ_no(String q_no){this.q_no=q_no;}
    public void setS_no(String s_no){this.s_no=s_no;}
    public void setS_name(String s_name){this.s_name=s_name;}
    public void setT_no(String t_no){this.t_no=t_no;}
    public void setT_name(String t_name){this.t_name=t_name;}
    public void setQuestion(String question){this.question=question;}
    public void setAnswer(String answer){this.answer = answer;}
    public void setQ_state(int state){this.q_state=state;}

    public String getQ_no(){return this.q_no;}
    public String getS_no(){return this.s_no;}
    public String getS_name(){return this.s_name;}
    public String getT_no(){return this.t_no;}
    public String getT_name(){return this.t_name;}
    public String getQuestion(){return this.question;}
    public String getAnswer(){return this.answer;}
    public int getQ_state(){return this.q_state;}
}
