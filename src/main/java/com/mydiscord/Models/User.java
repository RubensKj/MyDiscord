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
    private List<Long> servers;

    @ElementCollection
    private List<Long> friends;

    @ElementCollection
    private List<Long> privateChats;

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

    public List<Long> getServers() {
        return servers;
    }

    public List<Long> getFriends() {
        return friends;
    }

    public List<Long> getPrivateChats() {
        return privateChats;
    }

    public boolean isOnline() {
        return this.status.equals(StatusName.ONLINE);
    }

    public boolean isStatusEquals(StatusName statusName) {
        return this.status.equals(statusName);
    }
}
