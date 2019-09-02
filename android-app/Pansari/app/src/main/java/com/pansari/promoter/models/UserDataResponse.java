package com.pansari.promoter.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDataResponse {
    //{"userid":6,"username":"farinauser","name":"Farina Ali"}
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("username")
    @Expose
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
