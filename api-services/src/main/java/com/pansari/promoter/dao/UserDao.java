package com.pansari.promoter.dao;

import com.pansari.promoter.entity.User;

import java.util.List;

public interface UserDao {

    User authenticateUser(String username, String password);

    List<User> getAllUsers();

    User getUserById(int userid);

    int createUser(String name, String username, String password);

    void deleteUser(User user);

}

