package com.pansari.promoter.dao;

import com.pansari.promoter.entity.Store;

import java.util.List;

public interface StoreDao {

    List<Store> listStoresByZone(String zone);

    Store getStoreById(int storeId);

    List<String> getZones();

    List<Store> getStores();

    Store createStore(String storeName, String zone);

    void deleteStore(Store store);

}
