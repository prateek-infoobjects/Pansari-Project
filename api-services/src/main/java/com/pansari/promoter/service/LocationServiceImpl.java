package com.pansari.promoter.service;

import com.pansari.promoter.entity.LocationReading;
import com.pansari.promoter.dao.LocationReadingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service("locationService")
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationReadingDao locationReadinDao;

    private static final SimpleDateFormat formatNew = new SimpleDateFormat("yyy-MM-dd");

    @Override
    @Transactional
    public void addReading(int userid, double latitude, double longitude, long received) {

            locationReadinDao.addReading(userid, latitude, longitude, received, formatNew.format(new Date()));

    }

    @Override
    @Transactional
    public List<LocationReading> getLocationReadingsByUserIdAndDate(int userid, String datestamp) {
        try {
            return locationReadinDao.getLocationReadingsByUserIdAndDate(userid, datestamp);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
}
