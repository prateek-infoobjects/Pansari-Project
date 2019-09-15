package com.pansari.promoter.dao;

import com.pansari.promoter.entity.LocationReading;
import com.pansari.promoter.entity.Store;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("storeDao")
public class StoreDaoImpl extends AbstractDao implements StoreDao {

    @Override
    public List<Store> listStoresByZone(String zone) {
        Criteria criteria = getSession().createCriteria(Store.class);
        criteria.add(Restrictions.eq("active",true));
        criteria.add(Restrictions.eq("zone", zone));
        List<Store> l = criteria.list();
        return l;
    }

    @Override
    public Store getStoreById(int storeId) {
        Criteria criteria = getSession().createCriteria(Store.class);
        criteria.add(Restrictions.eq("storeId", storeId));
        Store s = (Store) criteria.uniqueResult();
        return s;
    }

    @Override
    public List<String> getZones() {
        Criteria criteria = getSession().createCriteria(Store.class);
        criteria.setProjection(Projections.distinct(Projections.projectionList()
                .add(Projections.property("zone"), "zone")));
        List<String> zones = criteria.list();
        return zones;

    }

    @Override
    public List<Store> getStores() {
        Criteria criteria = getSession().createCriteria(Store.class);
        criteria.add(Restrictions.eq("active",true));
        List<Store> l = criteria.list();
        return l;
    }

    @Override
    public Store createStore(String storeName, String zone) {
        Session session = getSession();
        Store store = null;
        try {
            store = new Store();
            store.setStorename(storeName);
            store.setZone(zone.toUpperCase());
            store.setActive(true);
            session.save(store);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw (ex);
        }
        return store;
    }

    @Override
    public void deleteStore(Store store) {
        Session session = getSession();
        try {
            session.update(store);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw (ex);
        }
    }
}
