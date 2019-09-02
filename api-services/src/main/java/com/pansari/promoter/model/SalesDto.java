package com.pansari.promoter.model;


import java.util.Set;

public class SalesDto {

    int userid;
    String selected_date;
    String other_sale;
    String store_out_time;
    String other_remarks;
    String stock_not_available;
    String stock_short;
    String zone;
    int storeid;
    Set<ItemDto> items;

    public Set<ItemDto> getItems() {
        return items;
    }

    public void setItems(Set<ItemDto> items) {
        this.items = items;
    }



    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getSelected_date() {
        return selected_date;
    }

    public void setSelected_date(String selected_date) {
        this.selected_date = selected_date;
    }

    public String getOther_sale() {
        return other_sale;
    }

    public void setOther_sale(String other_sale) {
        this.other_sale = other_sale;
    }

    public String getStore_out_time() {
        return store_out_time;
    }

    public void setStore_out_time(String store_out_time) {
        this.store_out_time = store_out_time;
    }

    public String getOther_remarks() {
        return other_remarks;
    }

    public void setOther_remarks(String other_remarks) {
        this.other_remarks = other_remarks;
    }

    public String getStock_not_available() {
        return stock_not_available;
    }

    public void setStock_not_available(String stock_not_available) {
        this.stock_not_available = stock_not_available;
    }

    public String getStock_short() {
        return stock_short;
    }

    public void setStock_short(String stock_short) {
        this.stock_short = stock_short;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public int getStoreid() {
        return storeid;
    }

    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }


}
