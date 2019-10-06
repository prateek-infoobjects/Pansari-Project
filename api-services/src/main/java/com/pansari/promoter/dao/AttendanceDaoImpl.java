package com.pansari.promoter.dao;

import com.pansari.promoter.entity.Attendance;
import com.pansari.promoter.entity.Item;
import com.pansari.promoter.entity.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("attendanceDao")
public class AttendanceDaoImpl extends AbstractDao implements AttendanceDao {

    @Override
    public Attendance createAttendance(String dateStamp, String attendanceValue, User user) {
        Session session = getSession();
        Attendance attendance = null;
        try {
            attendance = new Attendance();
            attendance.setDatestamp(dateStamp);
            attendance.setAttendanceValue(attendanceValue);
            attendance.setCreated(System.currentTimeMillis());
            attendance.setUser(user);
            session.save(attendance);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw (ex);
        }
        return attendance;
    }
}
