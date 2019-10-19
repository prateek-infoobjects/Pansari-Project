package com.pansari.promoter.dao;

import com.pansari.promoter.entity.Sales;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    public List<Sales> fetchSales() {
        Criteria criteria = getSession().createCriteria(Sales.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.setMaxResults(5);
        List<Sales> l = criteria.list();
        return l;
    }


    @Override
    public List<Sales> fetchSalesForDate(String datestamp) {
        Criteria criteria = getSession().createCriteria(Sales.class);
        criteria.add(Restrictions.eq("selectedDate", datestamp));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.setMaxResults(5);
        List<Sales> l = criteria.list();
        return l;
    }
    
    @Override
    public List<Object[]> fetchSalesByNative(Set<String> dates) {
        Session session = getSession();
        SQLQuery query = session.createSQLQuery("" +
                "select distinct c.name, a.selected_date, b.storename from sales a " +
                "inner join stores b on a.storeid=b.storeid " +
                "inner join users c on a.userid=c.userid " +
                "where a.selected_date IN (:values) order by 2");
        query.setParameterList("values", dates);
        System.out.println(query.getQueryString());
        List<Object[]> rows = query.list();
        return rows;
    }
    
}
