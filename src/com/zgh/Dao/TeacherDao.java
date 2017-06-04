package com.zgh.Dao;

import com.zgh.Bean.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by feir4 on 2017/5/29.
 */
public class TeacherDao extends BaseDao{
    //查找所有教师
    public ArrayList<TeacherBean> selectTeachers(){
        ArrayList<TeacherBean> teachers=new ArrayList<TeacherBean>();
        String sql="select * from teacher";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            rst=pstmt.executeQuery();
            while(rst.next()){
                TeacherBean teacher=new TeacherBean(rst.getString("t_no"),
                        rst.getString("t_name"),
                        rst.getInt("t_age"),
                        rst.getString("t_department"),
                        rst.getString("t_prof"));
                teachers.add(teacher);

            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
    //按照教工号查找教师
    public TeacherBean selectById(String id){
        TeacherBean teacher=null;
        String sql="select * from teacher where t_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rst=pstmt.executeQuery();
            while(rst.next()){
                teacher=new TeacherBean(rst.getString("t_no"),
                        rst.getString("t_name"),
                        rst.getInt("t_age"),
                        rst.getString("t_department"),
                        rst.getString("t_prof"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }
    //查表得到要新增的教工号
    public String selectTeacherNo(int depart){
        int tea_no=0;
        String sql="select t_no from teacher where left(t_no,2)=? order by t_no";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,String.valueOf(depart));
            rst=pstmt.executeQuery();
            while(rst.next()){
                tea_no=Integer.parseInt(rst.getString("t_no"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(tea_no==0){
            return String.valueOf(depart)+"01";
        }
        else return String.valueOf(++tea_no);
    }
    //按照学院查找教师
    public ArrayList<TeacherBean> selectByDepart(String depart){
        ArrayList<TeacherBean> teachers=new ArrayList<TeacherBean>();
        String sql="select t_no,t_name from teacher where t_department=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,depart);
            rst=pstmt.executeQuery();
            while(rst.next()){
                TeacherBean teacher=new TeacherBean();
                teacher.setT_ID(rst.getString("t_no"));
                teacher.setT_Name(rst.getString("t_name"));
                teachers.add(teacher);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
    //添加教师
    public int addTeacher(TeacherBean teacher){
        int row=0;
        String sql="insert into teacher values(?,?,?,?,?)";
        try {
            conn= dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,teacher.getT_ID());
            pstmt.setString(2,teacher.getT_Name());
            pstmt.setInt(3,teacher.getT_Age());
            pstmt.setString(4,teacher.getT_Depart());
            pstmt.setString(5,teacher.getT_Prof());
            row=pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
    //删除教师
    public int delTeacher(String t_id){
        int row=0;
        String sql="delete from teacher where t_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,t_id);
            row=pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
    //更改教师信息
    public int updateTeacher(String id,String name,String depart,String prof){
        int row=0;
        String sql="update teacher set t_name=?,t_department=?,t_prof=? where t_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,depart);
            pstmt.setString(3,prof);
            pstmt.setString(4,id);
            row=pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
    //查表得到下一条评价的ID
    public String selectTEID(String t_no,String c_no){
        String te_id=null;
        String sql="select te_id from teacher_evaluate where t_no=? and c_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,t_no);
            pstmt.setString(2,c_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                te_id=rst.getString("te_id");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(te_id==null){
            return t_no+c_no.substring(2,6)+"001";
        }
        else
            return String.valueOf(Integer.parseInt(te_id)+1);
    }
    //新增评价
    public String addTeacherEvaluate(String te_id,String t_no,String c_no,int score,String t_comment){
        String message="";
        String sql="insert into teacher_evaluate values(?,?,?,?,?)";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,te_id);
            pstmt.setString(2,t_no);
            pstmt.setString(3,c_no);
            pstmt.setInt(4,score);
            pstmt.setString(5,t_comment);
            int row=pstmt.executeUpdate();
            if(row!=0){
                message="评价成功";
            }
            else
                message="评价失败";
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }
    //按学号查找该学生评价的列表，学生界面显示
    public ArrayList<TeacherEvaluateBean> selectTeacherListBySno(String s_no){
        ArrayList<TeacherEvaluateBean> teacherList=new ArrayList<TeacherEvaluateBean>();

        String sql="select cs.c_no,cs.t_no from course_student as cs join course_teacher as ct on cs.c_no=ct.c_no and cs.t_no=ct.t_no where cs.s_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,s_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                sql="select c_name from course where c_no=?";
                pstmt=conn.prepareStatement(sql);
                String c_no=rst.getString("c_no");
                String t_no=rst.getString("t_no");
                pstmt.setString(1,c_no);
                ResultSet r1=pstmt.executeQuery();
                String c_name=null;
                while(r1.next()){
                    c_name=r1.getString("c_name");
                }
                sql="select t_name from teacher where t_no=?";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,t_no);
                ResultSet r2=pstmt.executeQuery();
                String t_name=null;
                while(r2.next()){
                    t_name=r2.getString("t_name");
                }
                TeacherEvaluateBean te=new TeacherEvaluateBean();
                te.setC_no(c_no);
                te.setC_name(c_name);
                te.setT_no(t_no);
                te.setT_name(t_name);
                teacherList.add(te);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherList;
    }
    //按照教师和课程查找评价，教工界面显示
    public ArrayList<TeacherEvaluateBean> selectEvaluateByTnoCno(String t_no,String c_no){
        ArrayList<TeacherEvaluateBean> evaluateList=new ArrayList<TeacherEvaluateBean>();
        String sql="select * from teacher_evaluate where t_no=? and c_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,t_no);
            pstmt.setString(2,c_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                TeacherEvaluateBean te=new TeacherEvaluateBean();
                te.setC_no(rst.getString("c_no"));
                te.setT_no(rst.getString("t_no"));
                te.setScore(rst.getInt("score"));
                te.setT_comment(rst.getString("t_comment"));
                evaluateList.add(te);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evaluateList;
    }
    //查找教学班未打分的学生
    public ArrayList<GradeBean> selectStudentByTnoCno(String c_no,String t_no){
        ArrayList<GradeBean> gradeList=new ArrayList<GradeBean>();
        String sql="select * from course_student where c_no=? and t_no=? and s_grade=-1";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,c_no);
            pstmt.setString(2,t_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                GradeBean sg=new GradeBean();
                sg.setC_no(rst.getString("c_no"));
                sg.setS_no(rst.getString("s_no"));
                sg.setT_no(rst.getString("t_no"));
                sql="select s_name from student where s_no=?";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,sg.getS_no());
                ResultSet r=pstmt.executeQuery();
                while(r.next()){
                    sg.setS_name(r.getString("s_name"));
                }
                sql="select c_name from course where c_no=?";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,sg.getC_no());
                r=pstmt.executeQuery();
                while(r.next()){
                    sg.setC_name(r.getString("c_name"));
                }
                gradeList.add(sg);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeList;
    }
    //成绩录入
    public int addGrade(ArrayList<GradeBean> gradeList,ArrayList<String> grade){
        int row=0;
        String sql="";
        try {
            conn=dataSource.getConnection();
            for(int i=0;i<gradeList.size();i++){
                sql="select cs_id from course_student where c_no=? and s_no=? and t_no=?";
                String cs_id="";
                pstmt=conn.prepareStatement(sql);
                String c_no=gradeList.get(i).getC_no();
                pstmt.setString(1, c_no);
                String s_no=gradeList.get(i).getS_no();
                pstmt.setString(2,s_no);
                String t_no=gradeList.get(i).getT_no();
                pstmt.setString(3,t_no);
                rst=pstmt.executeQuery();
                while(rst.next()){
                    cs_id=rst.getString("cs_id");
                }
                sql="update course_student set s_grade=? where cs_id=?";
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,Integer.parseInt(grade.get(i)));
                pstmt.setString(2,cs_id);
                int result=pstmt.executeUpdate();
                if(result==1)
                    row++;
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
