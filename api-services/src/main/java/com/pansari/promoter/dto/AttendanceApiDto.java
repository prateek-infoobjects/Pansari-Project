package com.pansari.promoter.dto;

import com.pansari.promoter.entity.User;

import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class AttendanceApiDto {

    String datestamp;
    String attendancevalue;
    int userid;

    public String getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(String datestamp) {
        this.datestamp = datestamp;
    }

    public String getAttendancevalue() {
        return attendancevalue;
    }

    public void setAttendancevalue(String attendancevalue) {
        this.attendancevalue = attendancevalue;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

}
