package com.zgh.Dao;

import com.zgh.Bean.QuestionBean;
import com.zgh.Bean.QuestionListBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by feir4 on 2017/6/4.
 */
public class QuestionDao extends BaseDao {
    //查找提问的问题
    public ArrayList<QuestionBean> selectQuestionsAsked(String t_no){
        ArrayList<QuestionBean> questionsAsked=new ArrayList<QuestionBean>();
        String sql="select * from question where t_no=? and q_state=0";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,t_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                QuestionBean question=new QuestionBean();
                question.setQ_no(rst.getString("q_no"));
                question.setT_no(rst.getString("t_no"));
                question.setQuestion(rst.getString("q_question"));
                question.setQ_state(rst.getInt("q_state"));
                questionsAsked.add(question);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionsAsked;
    }
    //查询下一个问题ID
    public String selectQuestionID(String s_no,String t_no){
        String q_id="";
        String sql="select q_no from question where s_no=? and t_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,s_no);
            pstmt.setString(2,t_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                q_id=rst.getString("q_no");
            }
            if(q_id.equals(""))
                q_id=s_no+t_no+"001";
            else
                q_id=String.valueOf(Long.parseLong(q_id)+1);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return q_id;
    }
    //学生提问
    public String addQuestion(String q_no,String s_no,String question,String t_no){
        String result="";
        String sql="insert into question(q_no,s_no,q_question,t_no) values (?,?,?,?)";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,q_no);
            pstmt.setString(2,s_no);
            pstmt.setString(3,question);
            pstmt.setString(4,t_no);
            int row=pstmt.executeUpdate();
            if(row==1)
                result="提问成功";
            else
                result="由于程序员原因，提问失败";
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    //查找提出过的问题，状态：0——未回答，1——已回答未查看，2——已查看
    public ArrayList<QuestionBean> selectQuestionsAnswered(String s_no,int q_state){
        ArrayList<QuestionBean> questions=new ArrayList<QuestionBean>();
        String sql="select * from question where s_no=? and q_state=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,s_no);
            pstmt.setInt(2,q_state);
            rst=pstmt.executeQuery();
            while(rst.next()){
                QuestionBean question=new QuestionBean();
                question.setQ_no(rst.getString("q_no"));
                question.setS_no(rst.getString("s_no"));
                question.setQuestion(rst.getString("q_question"));
                question.setS_no(rst.getString("t_no"));
                question.setAnswer(rst.getString("q_answer"));
                question.setQ_state((rst.getInt("q_state")));
                sql="select s_name from student where s_no=?";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,s_no);
                ResultSet r=pstmt.executeQuery();
                while(r.next()){
                    question.setS_name(r.getString("s_name"));
                }
                sql="select t_name from teacher where t_no=?";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,question.getT_no());
                r=pstmt.executeQuery();
                while(r.next()){
                    question.setT_name(r.getString("t_name"));
                }
                questions.add(question);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
    //教师回答问题
    public String addAnswer(String t_no,String q_no,String answer){
        String result="";
        String sql="update question set q_answer=?,q_state=?,t_no=? where q_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,answer);
            pstmt.setInt(2,1);
            pstmt.setString(3,t_no);
            pstmt.setString(4,q_no);
            int row=pstmt.executeUpdate();
            if(row==1){
                result="回答成功";
            }
            else
                result="由于管理员的原因，回答失败";
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    //修改问题状态
    public String editq_state(String q_no,int q_state){
        String result="";
        String sql="update question set q_state=? where q_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,q_state);
            pstmt.setString(2,q_no);
            int row=pstmt.executeUpdate();
            if(row==1){
                result="修改成功";
            }
            else{
                result="修改失败";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    //根据问题ID查找问题
    public QuestionBean selectQuestionByQno(String q_no){
        QuestionBean question=new QuestionBean();
        String sql="select * from question where q_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,q_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                question.setQ_no(rst.getString("q_no"));
                question.setS_no(rst.getString("s_no"));
                question.setQuestion(rst.getString("q_question"));
                question.setT_no(rst.getString("t_no"));
                question.setAnswer(rst.getString("q_answer"));
                question.setQ_state((rst.getInt("q_state")));
                sql="select s_name from student where s_no=?";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,rst.getString("s_no"));
                ResultSet r=pstmt.executeQuery();
                while(r.next()){
                    question.setS_name(r.getString("s_name"));
                }
                sql="select t_name from teacher where t_no=?";
                pstmt=conn.prepareStatement(sql);
                String t_no=question.getT_no();
                pstmt.setString(1,t_no);
                r=pstmt.executeQuery();
                while(r.next()){
                    question.setT_name(r.getString("t_name"));
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }
}
