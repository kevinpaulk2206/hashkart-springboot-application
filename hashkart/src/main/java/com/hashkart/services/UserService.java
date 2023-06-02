package com.hashkart.services;

import com.hashkart.model.User;

import java.util.List;

public interface UserService {
    User getUserById(String userId);
    void createUser(User user);
    void updateUser(String userId, User updatedUser);

    void updateUser(User user);

    void deleteUser(String userId);
    List<User> getAllUsers();
}
