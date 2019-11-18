package com.mydiscord.Models;

import javax.persistence.*;

@Entity
public class MessagePrivate extends Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User user;

    public MessagePrivate() {
    }

    public MessagePrivate(User user, String message) {
        this.user = user;
        super.setMessage(message);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
