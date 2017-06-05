package com.zgh.Bean;

import com.zgh.Dao.QuestionDao;
import sun.jvm.hotspot.oops.Array;

import java.util.ArrayList;

/**
 * Created by feir4 on 2017/6/4.
 */
public class QuestionListBean {
    private ArrayList<QuestionBean> questionsAsked;
    private ArrayList<QuestionBean> questionsAnswered;


    public QuestionListBean(){}

    public void setQuestionsAsked(String t_no){
        QuestionDao questiondao=new QuestionDao();
        this.questionsAsked=questiondao.selectQuestionsAsked(t_no);
    }
    public ArrayList<QuestionBean> getQuestionsAsked(){return this.questionsAsked;}
    public ArrayList<QuestionBean> getQuestionsAnswered(){return this.questionsAnswered;}

}
