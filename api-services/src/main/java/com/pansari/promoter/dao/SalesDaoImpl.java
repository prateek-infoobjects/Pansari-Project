package com.pansari.promoter.dao;

import com.pansari.promoter.entity.Item;
import com.pansari.promoter.entity.Sales;
import com.pansari.promoter.entity.Store;
import com.pansari.promoter.entity.User;
import com.pansari.promoter.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("salesDao")
public class SalesDaoImpl extends AbstractDao implements SalesDao {


    @Override
    public void createSale(Sales sale) {
        Session session = getSession();
        try {
            session.save(sale);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw (ex);
        }
    }
}
