package com.pansari.promoter.service;

import com.pansari.promoter.entity.Store;
import com.pansari.promoter.entity.User;
import com.pansari.promoter.dao.UserDao;
import com.pansari.promoter.exceptions.CustomException;
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

    @Override
    @Transactional
    public int createUser(String name, String username, String password) {
        return userDao.createUser(name, username, password);
    }

    @Override
    @Transactional
    public void deleteUserById(int userId) throws CustomException {
        User user = userDao.getUserById(userId);
        if(user==null)
        {
            logger.warning("User doesn't exists");
            throw new CustomException(400, "Wrong user id received");
        }
        user.setActive(false);
        userDao.deleteUser(user);
    }
}
