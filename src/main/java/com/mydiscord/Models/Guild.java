package com.mydiscord.Models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Guild {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long owner;

    private String name;

    private String avatar;

    @ElementCollection
    private List<Long> tags;

    @ElementCollection
    private List<Long> chats;

    @ElementCollection
    private List<Long> channels;

    @ElementCollection
    private List<Long> members;

    @ElementCollection
    private List<Long> bans;

    @ElementCollection
    private Set<Long> inviteLinks;

    public Guild() {
    }

    public Guild(Long owner, String name, String avatar) {
        this.owner = owner;
        this.name = name;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Long> getTags() {
        return tags;
    }

    public void setTags(List<Long> tags) {
        this.tags = tags;
    }

    public List<Long> getChats() {
        return chats;
    }

    public void setChats(List<Long> chats) {
        this.chats = chats;
    }

    public List<Long> getChannels() {
        return channels;
    }

    public void setChannels(List<Long> channels) {
        this.channels = channels;
    }

    public List<Long> getMembers() {
        return members;
    }

    public void setMembers(List<Long> members) {
        this.members = members;
    }

    public List<Long> getBans() {
        return bans;
    }

    public void setBans(List<Long> bans) {
        this.bans = bans;
    }

    public Set<Long> getInviteLinks() {
        return inviteLinks;
    }

    public void setInviteLinks(Set<Long> inviteLinks) {
        this.inviteLinks = inviteLinks;
    }
}