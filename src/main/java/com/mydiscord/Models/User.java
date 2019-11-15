package com.mydiscord.Models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String avatar;

    private StatusName status;

    @ElementCollection
    private Set<Long> servers;

    @ElementCollection
    private Set<Long> friends;

    @ElementCollection
    private Set<Long> privateChats;

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

    public void setRoles(Set<Role> roles) {
        super.setRoles(roles);
    }

    public String getAvatar() {
        return avatar;
    }

    public StatusName getStatus() {
        return status;
    }

    public void setStatus(StatusName status) {
        this.status = status;
    }

    public Set<Long> getServers() {
        return servers;
    }

    public Set<Long> getFriends() {
        return friends;
    }

    public Set<Long> getPrivateChats() {
        return privateChats;
    }

    public boolean isOnline() {
        return this.status.equals(StatusName.ONLINE);
    }

    public boolean isStatusEquals(StatusName statusName) {
        return this.status.equals(statusName);
    }
}
