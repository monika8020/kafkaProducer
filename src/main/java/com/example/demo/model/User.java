package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="T_Kafka_Producer")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id ;
    @NotEmpty(message = "Please provide valid first name.")
    @Column(name="first_name" ,nullable = false)
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @NotEmpty(message = "Please provide valid email id")
    @Email
    @Column(name="email")
    private String email;
    @Column(name="password")
    @NotEmpty()
    @Size(min =8 , message ="password should have at least 8 characters")
    private String password;
}
