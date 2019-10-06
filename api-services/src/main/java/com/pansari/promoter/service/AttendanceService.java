package com.pansari.promoter.service;

import com.pansari.promoter.entity.Attendance;
import com.pansari.promoter.entity.User;
import com.pansari.promoter.exceptions.CustomException;

public interface AttendanceService {

    public Attendance createAttendance(String dateStamp, String attendanceValue, int userid) throws CustomException;
}
