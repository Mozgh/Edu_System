package com.zgh.Dao;

import com.zgh.Bean.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by feir4 on 2017/5/23.
 */
public class UserDao extends BaseDao{
    private PreparedStatement pstmt=null;

    //根据ID查找用户信息
        public UserBean findById(String id,String identity){
            String sql="select * from sys_user where id=? and identity=?";
            ResultSet rst=null;
            UserBean userbean=null;
            try {
                Connection conn= dataSource.getConnection();
                pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setInt(2,Integer.parseInt(identity));
            rst=pstmt.executeQuery();
            //conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
                if(rst.next()){
                    String id1=rst.getString("id");
                    String password=rst.getString("password");
                    int identityselected=rst.getInt("identity");
                    userbean=new UserBean(id1,password,identityselected);
                }
            //userbean=new UserBean(rst.getString("id"),rst.getString("password"),rst.getInt("identity"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userbean;
    }
    //添加用户
    public int addUser(String id,String pwd,int identity){
        String sql="insert into sys_user values(?,?,?)";
        PreparedStatement pstmt=null;
        int n=0;
        try {
            Connection conn= dataSource.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,pwd);
            pstmt.setInt(3,identity);
            n=pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
