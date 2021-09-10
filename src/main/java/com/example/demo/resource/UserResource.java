package com.example.demo.resource;

import com.example.demo.controller.UserController;
import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Validated
@RestController
@RequestMapping("/kafkaProducer")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    @Value("${kafka.topic}")
    private String TOPIC;
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping(value = "/userData")
    public String postUserData(@RequestBody @Valid User user) {
        logger.trace("Entering postUser method");
        kafkaTemplate.send(TOPIC, user);
        logger.info("User data saved and published to kafka topic" + TOPIC + "successfully");
        return ("User data saved and published to kafka topic" + TOPIC + "successfully");
    }
}