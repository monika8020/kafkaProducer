package com.example.demo.service.impl;

import com.example.demo.controller.UserController;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        logger.trace("Entering method saveUser");
        logger.info("saveUser:" + "creating new user" + user.getFirstName());
        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        logger.trace("Entering method getAllUsers");
        return repository.findAll();
    }

    @Override
    public User getUserById(long id) {
        logger.trace("Entering method getUserById");
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User does not exist in the database", "id", id));
    }

    @Override
    public User updateUserById(User User, long id) {
        logger.trace("Entering method updateUserById");
        // we need to check whether User with given id is exist in DB or not
        User existingUser = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Unable to update the user info", "Id", id));

        existingUser.setFirstName(User.getFirstName());
        existingUser.setLastName(User.getLastName());
        existingUser.setEmail(User.getEmail());
        existingUser.setPassword(User.getPassword());
        // save existing User to DB
        repository.save(existingUser);
        logger.info("User with id " + id + "updated sucessfully");
        return existingUser;
    }


    @Override
    public void deleteUser(long id) {
        logger.trace("Entering method deleteUser");
        // check whether a User exist in a DB or not
        repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Unable to delete ,user doesn't exist for", "Id", id));
        repository.deleteById(id);
        logger.info("User with id " + id + "deleted sucessfully");
    }

    @Override
    public List<User> getByFirstName(String firstName) {
        logger.trace("Entering method getByFirstName");
        return repository.findByFirstName(firstName);

    }

    @Override
    public User getByemail(String email) {
        logger.trace("Entering method getUserById");
       return repository.findByemail(email).orElseThrow(() ->
                new ResourceNotFoundException("Unable to delete ,user doesn't exist for", "Id", email));
    }
}