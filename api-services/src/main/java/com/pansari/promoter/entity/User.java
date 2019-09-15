package com.pansari.promoter.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

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

    //, columnDefinition = "TINYINT"
    @Column(name="active", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean active;

    @Column(name="role")
    private String role;

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

    public int getUserid() {
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

    @JsonIgnore
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @JsonIgnore
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}