package org.communis.practice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;



}
