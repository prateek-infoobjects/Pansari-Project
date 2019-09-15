package com.pansari.promoter.dao;

import com.pansari.promoter.entity.Item;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemDao")
public class ItemDaoImpl extends AbstractDao implements ItemDao {

    @Override
    public List<Item> listItems() {
        Criteria criteria = getSession().createCriteria(Item.class);
        criteria.add(Restrictions.eq("active",true));
        List<Item> l = criteria.list();
        return l;
    }

    @Override
    public Item findById(int itemId) {
        Criteria criteria = getSession().createCriteria(Item.class);
        criteria.add(Restrictions.eq("itemId", itemId));
        Item s = (Item) criteria.uniqueResult();
        return s;
    }

    @Override
    public Item createItem(String itemName, String primaryCategory, String secondaryCategory) {
        Session session = getSession();
        Item item = null;
        try {
            item = new Item();
            item.setItemName(itemName);
            item.setPrimaryCategory(primaryCategory);
            item.setSecondaryCategory(secondaryCategory);
            item.setActive(true);

            session.save(item);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw (ex);
        }
        return item;
    }

    @Override
    public void deleteItem(Item item) {
        Session session = getSession();
        try {
            session.update(item);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw (ex);
        }
    }
}
