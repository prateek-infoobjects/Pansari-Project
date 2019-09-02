package com.pansari.promoter.dao;

import com.pansari.promoter.entity.LocationReading;

import java.util.List;

public interface LocationReadingDao {

    void addReading(int userid, double latitude, double longitude, long received, String dateStamp);

    List<LocationReading> getLocationReadingsByUserIdAndDate(int userid, String datestamp);
}
