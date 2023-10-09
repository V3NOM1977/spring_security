package com.example.spring_security.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String name;

    private String email;

    private String password;

    public User(
            String name,
            String email,
            String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String toString() {
        return "User["
                + "userId = " + getUserId()
                + "name = " + getName()
                + "email = " + getEmail()
                + "password = " + getPassword()
                + "]";
    }

}
