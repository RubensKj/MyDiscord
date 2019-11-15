package com.mydiscord.Models;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DynamicUpdate
public class Guild {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long owner;

    private String name;

    private String avatar;

    @ElementCollection
    private Set<Long> tags;

    @ElementCollection
    private Set<Long> textChannels;

    @ElementCollection
    private Set<Long> voiceChannels;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Long> members = new HashSet<Long>();

    @ElementCollection
    private Set<Long> bans;

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

    public Set<Long> getTags() {
        return tags;
    }

    public void setTags(Set<Long> tags) {
        this.tags = tags;
    }

    public Set<Long> getTextChannels() {
        return textChannels;
    }

    public void setTextChannels(Set<Long> textChannels) {
        this.textChannels = textChannels;
    }

    public Set<Long> getVoiceChannels() {
        return voiceChannels;
    }

    public void setVoiceChannels(Set<Long> voiceChannels) {
        this.voiceChannels = voiceChannels;
    }

    public Set<Long> getMembers() {
        return members;
    }

    public void setMembers(Set<Long> members) {
        this.members = members;
    }

    public Set<Long> getBans() {
        return bans;
    }

    public void setBans(Set<Long> bans) {
        this.bans = bans;
    }

    public Set<Long> getInviteLinks() {
        return inviteLinks;
    }

    public void setInviteLinks(Set<Long> inviteLinks) {
        this.inviteLinks = inviteLinks;
    }
}
