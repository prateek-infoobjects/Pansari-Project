package com.pansari.promoter.service;

import com.pansari.promoter.entity.User;

import java.util.List;

public interface UserService {
    User authenticateUser(String username, String password);

    List<User> getAllUsers();
}
