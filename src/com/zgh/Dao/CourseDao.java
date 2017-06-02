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
    public ArrayList<CourseBean> selectCourseTeacher(String c_no,String t_no){
        String sql="select ct_id,course.c_no,c_name,c_department,t_no,c_time,c_room,c_info,credit from course_teacher join course on course_teacher.c_no=course.c_no";
        CourseBean course;
        ArrayList<CourseBean> courselist=new ArrayList<CourseBean>();
        try {
            conn=dataSource.getConnection();
            if(!c_no.equals("")&&!t_no.equals("")){
                sql+=" where course.c_no=? and t_no=?";
                pstmt= conn.prepareStatement(sql);
                pstmt.setString(1,c_no);
                pstmt.setString(2,t_no);
            }else if(c_no.equals("")&&!t_no.equals("")){
                sql+=" where t_no=?";
                pstmt= conn.prepareStatement(sql);
                pstmt.setString(1,t_no);
            }else if(!c_no.equals("")&&t_no.equals("")){
                sql+=" where course.c_no=?";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,c_no);
            }else if(c_no.equals("")&&t_no.equals("")){
                pstmt= conn.prepareStatement(sql);
            }
            rst=pstmt.executeQuery();
            while(rst.next()){
                course=new CourseBean(rst.getString("ct_id"),
                        rst.getString("course.c_no"),
                        rst.getString("c_name"),
                        rst.getString("c_department"),
                        rst.getString("c_info"),
                        rst.getInt("credit"),
                        rst.getString("t_no"),
                        rst.getString("c_room"),
                        rst.getString("c_time"));
                course.setT_ID(rst.getString("t_no"));
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

    public CourseBean selectCourseTeacher(String ct_id){
        String sql="select ct_id,course.c_no,c_name,c_department,t_no,c_time,c_room,c_info credit from course_teacher join course on course_teacher.c_no=course.c_no where ct_id=?";
        CourseBean course=new CourseBean();
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,ct_id);
            rst=pstmt.executeQuery();
            while(rst.next()){
                course=new CourseBean(rst.getString("ct_id"),
                        rst.getString("course.c_no"),
                        rst.getString("c_name"),
                        rst.getString("c_department"),
                        rst.getString("c_info"),
                        rst.getInt("credit"),
                        rst.getString("t_no"),
                        rst.getString("c_room"),
                        rst.getString("c_time"));
                course.setT_ID(rst.getString("t_no"));
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
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
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

    public String selectCT_ID(String c_no,String t_no){
        int ct_id=0;
        String sql="select ct_id from course_teacher where c_no=? and t_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,c_no);
            pstmt.setString(2,t_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                ct_id=Integer.parseInt(rst.getString("ct_id"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(ct_id==0){
            return c_no+t_no.substring(2,4)+"01";
        }
        else
            return String.valueOf(++ct_id);
    }

    public int addCourse(String c_no,String c_name,String c_department,int c_credit,String c_info){
        int row=0;
        String sql="insert into course values(?,?,?,?,?)";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,c_no);
            pstmt.setString(2,c_name);
            pstmt.setString(3,c_department);
            pstmt.setInt(4,c_credit);
            pstmt.setString(5,c_info);
            row=pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public String addCourse_Tea(String ct_id,String c_no,String t_no,String c_time,String c_room){
        String result="";
        String sql="select ct_id from course_teacher where c_time=? and c_room=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,c_time);
            pstmt.setString(2,c_room);
            rst=pstmt.executeQuery();
            while(rst.next()){
                result=rst.getString("ct_id");
            }
            if(!result.equals(""))
                return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql="insert into course_teacher values(?,?,?,?,?)";
        int row=0;
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,ct_id);
            pstmt.setString(2,c_no);
            pstmt.setString(3,t_no);
            pstmt.setString(4,c_time);
            pstmt.setString(5,c_room);
            row=pstmt.executeUpdate();
            conn.close();
            result="添加成功";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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

    public String addCourseStudent(String ct_id,String c_time,String s_no,String c_no,String t_no){
        int row=0;
        String message="";
        //判定该课程是否已选
        String sql="select * from course_student where c_no=? and t_no=? and s_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,c_no);
            pstmt.setString(2,t_no);
            pstmt.setString(3,s_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                message="该课程已选，不能重复选课！";
            }
            if(!message.equals("")){
                conn.close();
                return message;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //判定是否时间冲突
        sql="select c_time from course_student join course_teacher on (course_student.c_no=course_teacher.c_no and course_student.t_no=course_teacher.t_no) where s_no=?";
        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,s_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                if(rst.getString("c_time").equals(c_time)){
                    message="时间冲突！";
                }
            }
            if(message.equals("时间冲突!")){
                conn.close();
                return message;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //判断人数是否达到上限
        sql="select count(s_no) from course_student where c_no=? and t_no=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,c_no);
            pstmt.setString(2,t_no);
            rst=pstmt.executeQuery();
            int count=0;
            while(rst.next()){
                count=rst.getInt(1);
            }
            if(count>=30){
                message="超过人数限制";
                conn.close();
                return message;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //添加选课记录到course_student表
        sql="insert into course_student values(?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,s_no+c_no);
            pstmt.setString(2,c_no);
            pstmt.setString(3,s_no);
            pstmt.setString(4,t_no);
            row=pstmt.executeUpdate();
            if(row!=0){
                message="选课成功";
            }
            else
                message="选课失败";
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    public ArrayList<CourseBean> selectCourseListBySno(String s_no){
        ArrayList<CourseBean> courseList=new ArrayList<CourseBean>();
        CourseBean course;
        String c_no,t_no;
        String sql="";
        ResultSet rst1=null;

        sql="select c_no,t_no from course_student where s_no=?";
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,s_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                sql="select ct_id,course.c_no,c_name,c_department,t_no,c_time,c_room,c_info,credit from course_teacher join course on course_teacher.c_no=course.c_no where course.c_no=? and t_no=?;";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,rst.getString("c_no"));
                pstmt.setString(2,rst.getString("t_no"));
                rst1=pstmt.executeQuery();
                while(rst1.next()){
                    course=new CourseBean(rst1.getString("ct_id"),
                            rst1.getString("course.c_no"),
                            rst1.getString("c_name"),
                            rst1.getString("c_department"),
                            rst1.getString("c_info"),
                            rst1.getInt("credit"),
                            rst1.getString("t_no"),
                            rst1.getString("c_room"),
                            rst1.getString("c_time"));
                    course.setT_ID(rst1.getString("t_no"));
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
                    courseList.add(course);
                }

            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public String delCourseStudent(String s_no,String c_no,String t_no){
        String message="";
        String sql="select cs_id from course_student where s_no=? and c_no=? and t_no=?";
        String cs_id=null;
        try {
            conn=dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,s_no);
            pstmt.setString(2,c_no);
            pstmt.setString(3,t_no);
            rst=pstmt.executeQuery();
            while(rst.next()){
                cs_id=rst.getString("cs_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql="delete from course_student where cs_id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,cs_id);
            int row=pstmt.executeUpdate();
            if(row!=0){
                message="退课成功";
            }
            else
                message="退课失败";
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }
}
