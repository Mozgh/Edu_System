package com.zgh.Dao;

import com.zgh.Bean.StudentBean;
import com.zgh.Bean.TeacherBean;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by feir4 on 2017/5/29.
 */
public class TeacherDao extends BaseDao{
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

}
