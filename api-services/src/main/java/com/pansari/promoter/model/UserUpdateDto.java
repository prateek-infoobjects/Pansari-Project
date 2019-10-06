package com.pansari.promoter.model;


public class UserUpdateDto {

    private int userid;
    private String username;
    private String password;
    private String name;
    private int storeid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


    public int getStoreid() {
        return storeid;
    }

    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
