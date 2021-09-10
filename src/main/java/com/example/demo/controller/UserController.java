package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    //This API save User information in database and produce the user data to kafka topic.
    @PostMapping(value = "/addUser")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        return new ResponseEntity<User>(service.saveUser(user), HttpStatus.CREATED);

    }

    //get all user Rest API
    @GetMapping(value = "/allUsers")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    //build user by Id rest API


    @GetMapping(value = "userById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long UserId) {
        return new ResponseEntity<User>(service.getUserById(UserId), HttpStatus.OK);
    }

    @GetMapping(value = "userByFirstName/{firstName}")
    public List<User> getUserByFirstName(@PathVariable("firstName") String firstName) {
        return service.getByFirstName(firstName);
    }

    @GetMapping(value = "userByEmail{email}")
    public ResponseEntity<User> getUserByemail(@PathVariable("email") String email) {
        return new ResponseEntity<User>(service.getByemail(email), HttpStatus.OK);
    }
    // build update User REST API

    @PutMapping(value = "updateUser/{id}")
    public ResponseEntity<User> updateUserbyId(@PathVariable("id") long id
            , @RequestBody User User) {
        return new ResponseEntity<User>(service.updateUserById(User, id), HttpStatus.OK);
    }
    /*@PutMapping("{email}")
    public ResponseEntity<User> updateUserbyEmail(@PathVariable("email") String email
            , @RequestBody User User) {
        return new ResponseEntity<User>(service.updateUserBtEmail(User, email), HttpStatus.OK);
    }*/

    // build delete User REST API

    @DeleteMapping(value = "deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {

        // delete User from DB
        service.deleteUser(id);

        return new ResponseEntity<String>("User deleted successfully!.", HttpStatus.OK);
    }

}
