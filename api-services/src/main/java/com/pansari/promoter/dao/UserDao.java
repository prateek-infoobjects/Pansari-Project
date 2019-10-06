package com.pansari.promoter.dao;

import com.pansari.promoter.entity.Store;
import com.pansari.promoter.entity.User;

import java.util.List;

public interface UserDao {

    User authenticateUser(String username, String password);

    List<User> getAllUsers();

    User getUserById(int userid);

    int createUser(String name, String username, String password, Store store);

    void deleteUser(User user);

    int updateUser(User user, String name, String username, String password, Store store);

    User updateStoreForUser(User user, Store store);
}

