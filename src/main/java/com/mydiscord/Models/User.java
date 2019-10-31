package com.mydiscord.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class User extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public User() {
    }

    public User(String email, String username, String passwordEncoded) {
        super.setEmail(email);
        super.setUsername(username);
        super.setPassword(passwordEncoded);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setRolesToUser(Set<Role> roles) {
        super.setRoles(roles);
    }
}
