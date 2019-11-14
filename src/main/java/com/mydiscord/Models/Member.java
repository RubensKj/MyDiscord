package com.mydiscord.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long idOfUser;

    private String nickname;

    @ElementCollection
    private List<Long> tags;

    private boolean isOwner;

    public Member() {
    }

    public Member(Long idOfUser, String nickname, List<Long> tags, boolean isOwner) {
        this.idOfUser = idOfUser;
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

    public Long getIdOfUser() {
        return idOfUser;
    }

    public void setIdOfUser(Long idOfUser) {
        this.idOfUser = idOfUser;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Long> getTags() {
        return tags;
    }

    public void setTags(List<Long> tags) {
        this.tags = tags;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }
}
