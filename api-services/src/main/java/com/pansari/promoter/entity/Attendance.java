package com.pansari.promoter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="attendanceid")
    private int attendanceId;

    @Column(name="datestamp")
    private String datestamp;

    @Column(name="attendancevalue")
    private String attendanceValue;

    @OneToOne()
    @JoinColumn(name = "userid")
    private User user;

    @Column(name="created")
    private long created;


    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(String datestamp) {
        this.datestamp = datestamp;
    }

    public String getAttendanceValue() {
        return attendanceValue;
    }

    public void setAttendanceValue(String attendanceValue) {
        this.attendanceValue = attendanceValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }



}
