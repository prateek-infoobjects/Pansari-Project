package com.pansari.promoter.dao;

import com.pansari.promoter.entity.Item;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemDao")
public class ItemDaoImpl extends AbstractDao implements ItemDao {

    @Override
    public List<Item> listItems() {
        Criteria criteria = getSession().createCriteria(Item.class);
        List<Item> l = criteria.list();
        return l;
    }

    @Override
    public Item findById(int itemId) {
        Criteria criteria = getSession().createCriteria(Item.class);
        criteria.add(Restrictions.eq("itemId",itemId));
        Item s = (Item)criteria.uniqueResult();
        return s;
    }
}
