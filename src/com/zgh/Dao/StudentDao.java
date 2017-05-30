package com.zgh.Dao;

import com.zgh.Bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by feir4 on 2017/5/25.
 */
public class StudentDao extends BaseDao{
    //查询学生列表
    public ArrayList<StudentBean> selectStudents(){
        ArrayList<StudentBean> students=new ArrayList<StudentBean>();
        String sql="select * from student";
        try {
            conn= dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rst=pstmt.executeQuery();
            while(rst.next()){
                StudentBean student=new StudentBean(rst.getString("s_no"),
                        rst.getString("s_name"),
                        rst.getString("s_sex"),
                        rst.getInt("s_age"),
                        rst.getString("s_department"));
                students.add(student);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    //根据学号查询学生
    public StudentBean selectByID(String id){
        StudentBean student=null;
        String sql="select * from student where s_no=?";
        try {
            conn= dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rst=pstmt.executeQuery();
            if(rst.next()){
                student=new StudentBean(rst.getString("s_no"),
                        rst.getString("s_name"),
                        rst.getString("s_sex"),
                        rst.getInt("s_age"),
                        rst.getString("s_department"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
    //修改指定学号学生的姓名和学院，其他为不可修改项
    public int updateStudent(String id,String name,String depart){
        String sql="update student set s_name=?,s_department=? where s_no=?";
        int row=0;
        try {
            conn= dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,depart);
            pstmt.setString(3,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            row=pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
    //查找某年级某学院最大学号,返回为下一个新学号
    public String selectStudentNo(int age,int depart){
        int stu_no=0;
        String age_depart=String.valueOf(age%100)+String.valueOf(depart);
        String sql="select s_no from student where left(s_no,4)=? order by s_no";
        try {
            conn= dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,age_depart);
            rst=pstmt.executeQuery();
            while(rst.next()){
                stu_no=Integer.parseInt(rst.getString("s_no"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(stu_no==0){
            return String.valueOf(age%100)+String.valueOf(depart)+"01";
        }
        else return String.valueOf(++stu_no);
    }
    //添加学生
    public int addStudent(StudentBean student){
        int row=0;
        String sql="insert into student values(?,?,?,?,?);";
        try {
            conn= dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,student.getS_ID());
            pstmt.setString(2,student.getS_Name());
            pstmt.setString(3,student.getS_Sex());
            pstmt.setInt(4,student.getS_Age());
            pstmt.setString(5,student.getS_Depart());
            row=pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
    public int delStudent(String s_id){
        int row=0;
        String sql="delete from student where s_no=?";
        try {
            conn= dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,s_id);
            row=pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
