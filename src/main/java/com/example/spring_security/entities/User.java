package com.example.spring_security.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_authorities", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "authority_id") })
    private Set<Authority> authorities;

    public User(
            String name,
            String email,
            String password,
            Set<Authority> authorities) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
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

    public Set<Authority> getAuthorities() {
        return this.authorities;
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
