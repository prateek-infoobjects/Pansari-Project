package com.pansari.promoter.dao;

import com.pansari.promoter.entity.Store;
import com.pansari.promoter.entity.User;
import com.pansari.promoter.model.Roles;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {
    @Override
    public User authenticateUser(String username, String password) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username",username).ignoreCase());
        criteria.add(Restrictions.eq("password",password));
        criteria.add(Restrictions.eq("active",true));
        criteria.add(Restrictions.eq("role",Roles.USER.toString()));
        return (User) criteria.uniqueResult();
    }

    @Override
    public List<User> getAllUsers() {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("active",true));
        criteria.add(Restrictions.eq("role",Roles.USER.toString()));
        List<User> l = criteria.list();
        return l;
    }

    @Override
    public User getUserById(int userid) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("userid",userid));
        return (User) criteria.uniqueResult();
    }

    @Override
    public int createUser(String name, String username, String password, Store store) {
        Session session = getSession();
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setActive(true);
        user.setRole(Roles.USER.toString());
        user.setStore(store);
        try
        {
            session.save(user);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw (ex);
        }
        return user.getUserid();

    }

    @Override
    public void deleteUser(User user) {
        Session session = getSession();
        try{
            session.update(user);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw (ex);
        }
    }

    @Override
    public int updateUser(User user, String name, String username, String password) {
        Session session = getSession();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);

        try{
            session.update(user);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw (ex);
        }
        return user.getUserid();
    }

    @Override
    public User updateStoreForUser(User user, Store store) {
        Session session = getSession();
        user.setStore(store);
        try{
            session.update(user);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw (ex);
        }
        return user;
    }

}
