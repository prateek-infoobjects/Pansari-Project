package com.pansari.promoter.service;

import com.pansari.promoter.entity.User;
import com.pansari.promoter.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());


    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User authenticateUser(String username, String password) {
        logger.info("Authenticating for username - "+ username);
        return userDao.authenticateUser(username,password);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


}
