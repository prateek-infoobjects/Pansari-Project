package com.pansari.promoter.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SalesPostRequestObj implements Serializable {

    @SerializedName("userid")
    @Expose
    private Integer userId;
//    @SerializedName("created")
//    @Expose
//    private long created;
    @SerializedName("selected_date")
    @Expose
    private String selectedDate;
    @SerializedName("items")
    @Expose
    private List<SalesItemsRequest> items = null;
    @SerializedName("other_sale")
    @Expose
    private String otherSale;
    @SerializedName("store_out_time")
    @Expose
    private String storeOutTime;
    @SerializedName("other_remarks")
    @Expose
    private String otherRemarks;
    @SerializedName("stock_not_available")
    @Expose
    private String stockNotAvailable;
    @SerializedName("stock_short")
    @Expose
    private String stockShort;
    @SerializedName("zone")
    @Expose
    private String zone;
    @SerializedName("storeid")
    @Expose
    private Integer storeid;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

//    public long getCreated() {
//        return created;
//    }
//
//    public void setCreated(long created) {
//        this.created = created;
//    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public List<SalesItemsRequest> getItems() {
        return items;
    }

    public void setItems(List<SalesItemsRequest> items) {
        this.items = items;
    }

    public String getOtherSale() {
        return otherSale;
    }

    public void setOtherSale(String otherSale) {
        this.otherSale = otherSale;
    }

    public String getStoreOutTime() {
        return storeOutTime;
    }

    public void setStoreOutTime(String storeOutTime) {
        this.storeOutTime = storeOutTime;
    }

    public String getOtherRemarks() {
        return otherRemarks;
    }

    public void setOtherRemarks(String otherRemarks) {
        this.otherRemarks = otherRemarks;
    }

    public String getStockNotAvailable() {
        return stockNotAvailable;
    }

    public void setStockNotAvailable(String stockNotAvailable) {
        this.stockNotAvailable = stockNotAvailable;
    }

    public String getStockShort() {
        return stockShort;
    }

    public void setStockShort(String stockShort) {
        this.stockShort = stockShort;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Integer getStore() {
        return storeid;
    }

    public void setStore(Integer store) {
        this.storeid = store;
    }
}
