package com.pansari.promoter.service;

import com.pansari.promoter.entity.User;
import com.pansari.promoter.exceptions.CustomException;

import java.util.List;

public interface UserService {
    User authenticateUser(String username, String password);

    List<User> getAllUsers();

    int createUser(String name, String username, String password, int storeid) throws CustomException;

    int updateUser(int userid, String name, String username, int storeid) throws CustomException;

    User updateStoreForUser(int userid, int storeid) throws CustomException;

    void deleteUserById(int userId) throws CustomException;
}
