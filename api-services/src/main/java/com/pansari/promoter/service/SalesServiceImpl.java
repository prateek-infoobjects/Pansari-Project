package com.pansari.promoter.service;

import com.pansari.promoter.dao.ItemDao;
import com.pansari.promoter.dao.SalesDao;
import com.pansari.promoter.dao.StoreDao;
import com.pansari.promoter.dao.UserDao;
import com.pansari.promoter.entity.*;
import com.pansari.promoter.model.ItemDto;
import com.pansari.promoter.model.SalesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.logging.Logger;

@Service("salesService")
public class SalesServiceImpl implements SalesService {

    private static final Logger logger = Logger.getLogger(SalesServiceImpl.class.getName());

    @Autowired
    private SalesDao salesDao;

    @Autowired
    private StoreDao storeDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ItemDao itemDao;



    @Override
    @Transactional
    public void createSale(SalesDto salesDto) throws Exception {
        Store store;
        User user;

        Sales sale = new Sales();

        sale.setSelectedDate(salesDto.getSelected_date());
        sale.setOtherSale(salesDto.getOther_sale());
        sale.setStoreOutTime(salesDto.getStore_out_time());
        sale.setOtherRemarks(salesDto.getOther_remarks());
        sale.setStockNotAvailable(salesDto.getStock_not_available());
        sale.setStockShort(salesDto.getStock_short());
        sale.setZone(salesDto.getZone());
        sale.setCreated(System.currentTimeMillis());
        sale.setProductLines(new HashSet<ProductLine>());

        try {
            store= storeDao.getStoreById(salesDto.getStoreid());
            if(store==null)
            {
                System.out.println("Store doesn't exists");
                throw new Exception("Store doesn't exists");
            }
            sale.setStore(store);
            user= userDao.getUserById(salesDto.getUserid());
            if(user==null)
            {
                System.out.println("User doesn't exists");
                throw new Exception("User doesn't exists");
            }
            sale.setUser(user);
            for( ItemDto i: salesDto.getItems())
            {
                Item item = itemDao.findById(i.getId());
                ProductLine pl = new ProductLine();
              pl.setAnswer(i.getAnswer());

              pl.setItemId(i.getId());
              pl.setSale(sale);

              sale.getProductLines().add(pl);
            }
            salesDao.createSale(sale);
            logger.info("Sale created successfully for user id  -"+ salesDto.getUserid() + " with user name -"+ user.getName()
            + "for store -"+ store.getStoreName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            logger.severe("Exception while creating sale - {}"+e.getMessage() + " for user id  -"+ salesDto.getUserid());
            throw e;
        }

    }

    @Override
    @Transactional
    public List<Sales> getSales() {
        List<Sales> sales = salesDao.fetchSales();
        return sales;
    }

    @Transactional
    public List<Object[]> getSalesByDatesNatively(Set<String> dates) {
        return salesDao.fetchSalesByNative(dates);
    }
    
    @Override
    @Transactional
    public List<Sales> getSalesByDate(String datestamp) {
        return salesDao.fetchSalesForDate(datestamp);
    }


}
