package com.mydiscord.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private String nickname;

    @ElementCollection
    private Set<Long> tags;

    private boolean isOwner;

    public Member() {
    }

    public Member(User user, String nickname, Set<Long> tags, boolean isOwner) {
        this.user = user;
        this.nickname = nickname;
        this.tags = tags;
        this.isOwner = isOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Set<Long> getTags() {
        return tags;
    }

    public void setTags(Set<Long> tags) {
        this.tags = tags;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }
}
