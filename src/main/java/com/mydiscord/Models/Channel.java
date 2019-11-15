package com.mydiscord.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
public abstract class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String topic;

    @ElementCollection
    private Set<Long> tagCanAccess;

    @ElementCollection
    private Set<Long> tags;

    @ElementCollection
    private Set<Long> invitesLinks;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Set<Long> getTagCanAccess() {
        return tagCanAccess;
    }

    public void setTagCanAccess(Set<Long> tagCanAccess) {
        this.tagCanAccess = tagCanAccess;
    }

    public Set<Long> getTags() {
        return tags;
    }

    public void setTags(Set<Long> tags) {
        this.tags = tags;
    }

    public Set<Long> getInvitesLinks() {
        return invitesLinks;
    }

    public void setInvitesLinks(Set<Long> invitesLinks) {
        this.invitesLinks = invitesLinks;
    }
}
