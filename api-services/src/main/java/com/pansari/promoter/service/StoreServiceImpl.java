package com.pansari.promoter.service;

import com.pansari.promoter.controller.StoreController;
import com.pansari.promoter.exceptions.CustomException;
import com.pansari.promoter.entity.Store;
import com.pansari.promoter.dao.StoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service("storeService")
public class StoreServiceImpl implements StoreService {

    private static final Logger logger = Logger.getLogger(StoreServiceImpl.class.getName());


    @Autowired
    private StoreDao storeDao;

    @Override
    @Transactional
    public List<Store> listStoresByZone(String zone) throws CustomException {
        if (zone.equals("NORTH-DELHI") || zone.equals("EAST-DELHI") || zone.equals("SOUTH-DELHI") || zone.equals("WEST-DELHI") || zone.equals("OUTER-DELHI"))
            return storeDao.listStoresByZone(zone);
        else
            throw new CustomException(400, "Wrong zone passed");
    }

    @Override
    @Transactional
    public List<String> getZones() throws CustomException {
        return storeDao.getZones();
    }

    @Override
    @Transactional
    public List<Store> getStores() throws CustomException {
        return storeDao.getStores();
    }

    @Override
    @Transactional
    public Store createStore(String storeName, String zone) {
        return storeDao.createStore(storeName,zone);
    }

    @Override
    @Transactional
    public void deleteStore(int storeId) throws CustomException {
        Store store = storeDao.getStoreById(storeId);
        if(store==null)
        {
            logger.warning("Store doesn't exists");
            throw new CustomException(400, "Wrong store id received");
        }
        storeDao.deleteStore(store);
    }
}
