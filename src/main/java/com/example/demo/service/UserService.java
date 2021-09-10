package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
 User saveUser(User user);
 List<User> getAllUsers();
 User getUserById(long id);
 User updateUserById(User User, long id);
 void deleteUser(long id);
 List<User> getByFirstName(String firstName);
 User getByemail(String email);
}
