package com.pansari.promoter.dao;

import com.pansari.promoter.entity.Attendance;
import com.pansari.promoter.entity.User;

public interface AttendanceDao {

    Attendance createAttendance(String dateStamp, String attendanceValue, User user);
}
