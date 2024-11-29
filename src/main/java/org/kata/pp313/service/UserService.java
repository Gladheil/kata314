package org.kata.pp313.service;

import org.kata.pp313.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void saveUser(User user);
    void deleteUser(User user);
    List<User> getAll();
    User getUserById(int id);
    void deleteUserById(int id);
    User getUserByEmail(String email);
    boolean existsUserByEmail(String email);
}
