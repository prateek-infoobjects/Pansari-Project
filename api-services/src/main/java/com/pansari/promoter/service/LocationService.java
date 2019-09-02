package com.pansari.promoter.service;

import com.pansari.promoter.entity.LocationReading;

import java.util.List;

public interface LocationService {

    void addReading(int userid, double latitude, double longitude, long received);

    List<LocationReading> getLocationReadingsByUserIdAndDate(int userid, String datestamp);
}
