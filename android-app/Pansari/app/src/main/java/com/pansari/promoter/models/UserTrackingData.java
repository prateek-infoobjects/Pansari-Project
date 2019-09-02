package com.pansari.promoter.models;

import java.io.Serializable;

public class UserTrackingData implements Serializable {

    private double latitude;

    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getTimestamp() {
        return received;
    }

    public void setTimestamp(long timestamp) {
        this.received = timestamp;
    }

    private long userid;

    private long received;

}
