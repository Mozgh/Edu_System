package com.zgh.Dao;

import com.zgh.Bean.ClassroomBean;
import com.zgh.Bean.CourseBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by feir4 on 2017/5/30.
 */
public class CourseDao extends BaseDao {
    public ArrayList<CourseBean> selectCourseTeacher(String c_no){
        String sql="select course.c_no,c_name,c_department,t_no,c_time,c_room,c_info from course_teacher join course on course_teacher.c_no=course.c_no";
        CourseBean course;
        ArrayList<CourseBean> courselist=new ArrayList<CourseBean>();
        try {
            conn=dataSource.getConnection();
            if(c_no!=""){
                sql+=" where course.c_no=?";
            }
            pstmt=conn.prepareStatement(sql);
            if(c_no!=""){
                pstmt.setString(1,c_no);
            }
            rst=pstmt.executeQuery();
            while(rst.next()){
                course=new CourseBean(rst.getString("course.c_no"),
                        rst.getString("c_name"),
                        rst.getString("c_department"),
                        rst.getString("c_info"),
                        rst.getString("t_no"),
                        rst.getString("c_room"),
                        rst.getString("c_time"));
                pstmt=conn.prepareStatement("select t_name from teacher where t_no=?");
                pstmt.setString(1,course.getC_Teacher());
                ResultSet r=pstmt.executeQuery();
                while(r.next()){
                    course.setC_Teacher(r.getString("t_name"));
                }
                pstmt=conn.prepareStatement("select building,house from classroom where room_id=?");
                pstmt.setString(1,course.getC_Room());
                r=pstmt.executeQuery();
                while(r.next()){
                    course.setC_Room(r.getString("building")+r.getString("house"));
                }
                courselist.add(course);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courselist;
    }

    public ArrayList<ClassroomBean> selectClassroom(){
        String sql="select * from classroom where state=?";
        ArrayList<ClassroomBean> classrooms=new ArrayList<ClassroomBean>();
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,0);
            rst=pstmt.executeQuery();
            while(rst.next()){
                classrooms.add(new ClassroomBean(rst.getString("room_id"),
                        rst.getString("building"),
                        rst.getString("house"),
                        rst.getInt("seat"),
                        rst.getInt("state")));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classrooms;
    }

    public ArrayList<CourseBean> selectCourse(){
        String sql="select * from course";
        ArrayList<CourseBean> courses=new ArrayList<CourseBean>();
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            rst=pstmt.executeQuery();
            while(rst.next()){
                CourseBean course=new CourseBean();
                course.setC_ID(rst.getString("c_no"));
                course.setC_Name(rst.getString("c_name"));
                course.setC_Depart(rst.getString("c_department"));
                course.setC_Info(rst.getString("c_info"));
                courses.add(course);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    public String selectCourseNo(int depart){
        int c_no=0;
        String sql="select c_no from course where left(c_no,2)=? order by c_no";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,String.valueOf(depart));
            rst=pstmt.executeQuery();
            while(rst.next()){
                c_no=Integer.parseInt(rst.getString("c_no"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(c_no==0){
            return String.valueOf(depart)+"0001";
        }
        else return String.valueOf(++c_no);
    }

    public int addCourse(String c_no,String c_name,String c_department,String c_info){
        int row=0;
        String sql="insert into course values(?,?,?,?)";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,c_no);
            pstmt.setString(2,c_name);
            pstmt.setString(3,c_department);
            pstmt.setString(4,c_info);
            row=pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public int addCourse_Tea(String c_no,String t_no,String c_time,String c_room){
        String sql="insert into course_teacher values(?,?,?,?)";
        int row=0;
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,c_no);
            pstmt.setString(2,t_no);
            pstmt.setString(3,c_time);
            pstmt.setString(4,c_room);
            row=pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public CourseBean selectByCno(String c_no){
        String sql="select * from course where c_no=?";
        CourseBean course=new CourseBean();
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,c_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                course.setC_ID(rst.getString("c_no"));
                course.setC_Name(rst.getString("c_name"));
                course.setC_Depart(rst.getString("c_department"));
                course.setC_Info((rst.getString("c_info")));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    public int editCourseInfo(String info,String c_no){
        String sql="update course set c_info=? where c_no=?";
        int row=0;
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,info);
            pstmt.setString(2,c_no);
            row=pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}