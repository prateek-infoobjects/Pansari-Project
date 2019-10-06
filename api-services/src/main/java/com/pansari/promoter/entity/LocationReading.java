package com.pansari.promoter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="locationreading")
public class LocationReading {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationreadingid;
    private int userid;
    private double latitude;
    private double longitude;
    private long received;
    @JsonIgnore
    private long created;
    @JsonIgnore
    private long modified;
    @JsonIgnore
    private String datestamp;

    public long getLocationreadingid() {
        return locationreadingid;
    }

    public void setLocationreadingid(long locationreadingid) {
        this.locationreadingid = locationreadingid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

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

    public long getReceived() {
        return received;
    }

    public void setReceived(long received) {
        this.received = received;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getModified() {
        return modified;
    }

    public void setModified(long modified) {
        this.modified = modified;
    }

    public String getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(String datestamp) {
        this.datestamp = datestamp;
    }
}
