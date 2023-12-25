package com.example.EventManagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long ID;

    public Long getID() {
        return this.ID;
    }

    @Column(name = "USER_EMAIL")
    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String updatedEmail) {
        this.email = updatedEmail;
    }

    @Column(name = "USER_PASSWORD")
    private String password;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String updatedPassword) {
        this.password = updatedPassword;
    }

    public User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
