package com.pansari.promoter.entity;

import javax.persistence.*;

@Entity
@Table(name = "stores")
public class Store  implements java.io.Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="storeid")
    private int storeId;

    @Column(name="storename")
    private String storeName;


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

    public void setStorename(String storeName) {
        this.storeName = storeName;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }


}
