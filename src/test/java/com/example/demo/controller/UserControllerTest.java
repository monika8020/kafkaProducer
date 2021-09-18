package com.example.demo.controller;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
class UserControllerTest {
@Autowired
private TestRestTemplate testRestTemplate;

    @Test
    void createUser() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
        void getUserByIdTest() {
        ResponseEntity<User> response = testRestTemplate.getForEntity("/userById/1001",User.class);
        assertEquals(1001,response.getBody().getId());
        assertEquals("harsh",response.getBody().getFirstName());
    }

    @Test
    void getUserByFirstName() {
    }

    @Test
    void getUserByemail() {
    }

    @Test
    void updateUserbyId() {
    }

    @Test
    void deleteUser() {
    }
}