package com.mydiscord.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class TextChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String topic;

    private boolean isNSFW;

    @ElementCollection
    private List<Long> messages;

    @ElementCollection
    private List<Long> tags;

    @ElementCollection
    private List<Long> invitesLinks;

    public TextChannel() {
    }

    public TextChannel(String name, String topic, boolean isNSFW) {
        this.name = name;
        this.topic = topic;
        this.isNSFW = isNSFW;
    }


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

    public boolean isNSFW() {
        return isNSFW;
    }

    public void setNSFW(boolean NSFW) {
        isNSFW = NSFW;
    }

    public List<Long> getMessages() {
        return messages;
    }

    public void setMessages(List<Long> messages) {
        this.messages = messages;
    }

    public List<Long> getTags() {
        return tags;
    }

    public void setTags(List<Long> tags) {
        this.tags = tags;
    }

    public List<Long> getInvitesLinks() {
        return invitesLinks;
    }

    public void setInvitesLinks(List<Long> invitesLinks) {
        this.invitesLinks = invitesLinks;
    }
}
