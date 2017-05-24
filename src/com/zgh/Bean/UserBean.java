package com.zgh.Bean;

/**
 * Created by feir4 on 2017/5/24.
 */
public class UserBean {
    private String id;
    private String password;
    private int identity;

    public UserBean(String id,String password,int i){
        this.id=id;this.password=password;this.identity=i;
    }
    public void setId(String id){this.id=id;}
    public void setPassword(String password){this.password=password;}
    public void setIdentity(int i){this.identity=i;}

    public String getId(){return this.id;}
    public String getPassword(){return this.password;}
    public int getIdentity(){return this.identity;}
}
