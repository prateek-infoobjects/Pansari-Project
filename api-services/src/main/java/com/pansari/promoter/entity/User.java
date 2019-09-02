package com.pansari.promoter.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;


    private String username;


    private String password;


    private String name;

    public User() {

    }

    public User(int userid, String userName) {
        this.userid = userid;
        this.username = userName;
    }

    public User(int userid, String userName, String name) {
        this.userid = userid;
        this.username = userName;
        this.name = name;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}