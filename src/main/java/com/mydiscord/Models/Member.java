package com.mydiscord.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long idOfUser;

    private Long idOfServer;

    private String nickname;

    @ElementCollection
    private List<Long> tags;

    public Member() {
    }

    public Member(Long idOfUser, Long idOfServer, String nickname) {
        this.idOfUser = idOfUser;
        this.idOfServer = idOfServer;
        this.nickname = nickname;
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

    public Long getIdOfServer() {
        return idOfServer;
    }

    public void setIdOfServer(Long idOfServer) {
        this.idOfServer = idOfServer;
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
}
