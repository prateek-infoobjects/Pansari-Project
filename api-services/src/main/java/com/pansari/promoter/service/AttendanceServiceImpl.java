package com.pansari.promoter.service;

import com.pansari.promoter.dao.AttendanceDao;
import com.pansari.promoter.dao.ItemDao;
import com.pansari.promoter.dao.UserDao;
import com.pansari.promoter.entity.Attendance;
import com.pansari.promoter.entity.Item;
import com.pansari.promoter.entity.User;
import com.pansari.promoter.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {

    private static final Logger logger = Logger.getLogger(AttendanceServiceImpl.class.getName());

    @Autowired
    UserDao userDao;

    @Autowired
    AttendanceDao attendanceDao;

    @Override
    @Transactional
    public Attendance createAttendance(String dateStamp, String attendanceValue, int userId) throws CustomException {
        User user = userDao.getUserById(userId);
        if (user == null) {
            logger.warning("User doesn't exists");
            throw new CustomException(400, "Wrong user id received");
        }
        Attendance attendance = attendanceDao.createAttendance(dateStamp, attendanceValue, user);
        return attendance;
    }
}
