package com.zgh.Dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by feir4 on 2017/5/23.
 */
public class BaseDao {
    DataSource dataSource;
    PreparedStatement pstmt=null;
    Connection conn=null;
    ResultSet rst=null;
    public BaseDao(){
        try {
            Context context=new InitialContext();
            dataSource =(DataSource)context.lookup("java:comp/env/jdbc/edu_system");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    //返回一个连接对象
    public Connection getConnection() throws SQLException {
            return dataSource.getConnection();
    }
}
