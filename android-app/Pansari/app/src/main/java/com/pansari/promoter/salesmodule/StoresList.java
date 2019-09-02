package com.pansari.promoter.salesmodule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoresList {

    @SerializedName("storeId")
    @Expose
    private int storeId;
    @SerializedName("storeName")
    @Expose
    private String storeName;
    @SerializedName("zone")
    @Expose
    private String zone;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}
