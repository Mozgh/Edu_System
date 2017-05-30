package com.zgh.Bean;

/**
 * Created by feir4 on 2017/5/30.
 */
public class ClassroomBean {
    private String room_id;
    private String building;
    private String house;
    private int seat;
    private int state;

    public ClassroomBean(){}
    public ClassroomBean(String id,String building,String house,int seat,int state){
        this.room_id=id;this.building=building;this.house=house;this.seat=seat;this.state=state;
    }

    public void setRoom_id(String id){
        this.room_id=id;
    }
    public void setBuilding(String building){
        this.building=building;
    }
    public void setHouse(String house){
        this.house=house;
    }
    public void setSeat(int seat){
        this.seat=seat;
    }
    public void setState(int state){
        this.state=state;
    }

    public String getRoom_id(){return this.room_id;}
    public String getBuilding(){return this.building;}
    public String getHouse(){return this.house;}
    public int getSeat(){return this.seat;}
    public int getState(){return this.state;}
}
