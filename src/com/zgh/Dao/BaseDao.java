package com.zgh.Dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by feir4 on 2017/5/23.
 */
public class BaseDao {
    DataSource dataSourse;
    public BaseDao(){
        try {
            Context context=new InitialContext();
            dataSourse=(DataSource)context.lookup("java:comp/env/jdbc/edu_system");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    //返回一个连接对象
    public Connection getConnection() throws SQLException {
            return dataSourse.getConnection();
    }
}
