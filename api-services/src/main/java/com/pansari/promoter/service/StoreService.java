package com.pansari.promoter.service;

import com.pansari.promoter.exceptions.CustomException;
import com.pansari.promoter.entity.Store;

import java.util.List;

public interface StoreService {

    List<Store> listStoresByZone(String zone) throws CustomException;

    List<String> getZones() throws CustomException;

    List<Store> getStores() throws CustomException;

    Store createStore(String storeName, String zone);

    void deleteStore(int StoreId) throws CustomException;
}
