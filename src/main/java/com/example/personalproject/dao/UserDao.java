package com.example.personalproject.dao;

import com.example.personalproject.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User getUserByID(int userID);
    List<User> getAllUser();
    Optional<User> validateLogin(User user);
    void createNewUser(User user);
    void updateUser(User user);
    void deleteUser(int userID);
}
