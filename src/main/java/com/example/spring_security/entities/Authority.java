package com.example.spring_security.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorityId;

    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    public Authority(String name) {
        this.name = name;
    }

    public int getAuthorityId() {
        return this.authorityId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return this.users;
    }

}
