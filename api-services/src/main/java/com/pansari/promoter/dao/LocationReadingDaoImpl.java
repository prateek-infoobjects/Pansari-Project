package com.pansari.promoter.dao;

import com.pansari.promoter.entity.LocationReading;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository("locationReadingDaoImpl")
public class LocationReadingDaoImpl  extends AbstractDao implements LocationReadingDao {


    @Override
    public void addReading(int userid, double latitude, double longitude, long received, String dateStamp) {
        Session session = getSession();
        try
        {
            //tx = session.beginTransaction();
            LocationReading lr = new LocationReading();
            lr.setUserid(userid);
            lr.setLatitude(latitude);
            lr.setLongitude(longitude);
            lr.setReceived(received);
            lr.setCreated(System.currentTimeMillis());
            lr.setDatestamp(dateStamp);
            session.save(lr);
        }
        catch (HibernateException ex)
        {
            ex.printStackTrace();
            throw(ex);
        }

    }

    @Override
    public List<LocationReading> getLocationReadingsByUserIdAndDate(int userid, String datestamp) {
        Criteria criteria = getSession().createCriteria(LocationReading.class);
        criteria.add(Restrictions.eq("userid",userid));
        criteria.add(Restrictions.eq("datestamp",datestamp));
        criteria.addOrder(Order.asc("received"));
        List<LocationReading> l = criteria.list();
        return l;
    }
}
