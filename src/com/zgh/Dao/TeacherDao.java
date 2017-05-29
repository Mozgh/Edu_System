package com.zgh.Dao;

import com.zgh.Bean.TeacherBean;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.sun.javafx.tools.resource.DeployResource.Type.data;

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
}
