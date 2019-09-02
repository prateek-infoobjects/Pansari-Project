package com.pansari.promoter.dao;

import com.pansari.promoter.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {
    @Override
    public User authenticateUser(String username, String password) {
        System.out.println("username = [" + username + "], password = [" + password + "]");
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username",username));
        criteria.add(Restrictions.eq("password",password));
        return (User) criteria.uniqueResult();
    }

    @Override
    public List<User> getAllUsers() {
        Criteria criteria = getSession().createCriteria(User.class);
        List<User> l = criteria.list();
        return l;
    }

    @Override
    public User getUserById(int userid) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("userid",userid));
        return (User) criteria.uniqueResult();
    }
}
