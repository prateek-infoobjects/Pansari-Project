package com.pansari.promoter.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class AttendanceDto {

    public AttendanceDto() {

    }

    AttendanceDto(String name, Date date, String attendance) {
        this.name = name;
        this.date = date;
        this.attendance = attendance;
    }

    String name;

    Date date;

    String attendance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceDto that = (AttendanceDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(date, that.date) &&
                Objects.equals(attendance, that.attendance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, attendance);
    }

    class SortbyDate implements Comparator<AttendanceDto>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(AttendanceDto a, AttendanceDto b)
        {
            return a.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                    .compareTo(b.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        }
    }
}
