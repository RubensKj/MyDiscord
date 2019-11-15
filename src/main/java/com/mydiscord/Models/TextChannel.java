package com.mydiscord.Models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class TextChannel extends Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean isNSFW;

    @ElementCollection
    private Set<Long> messages;

    public TextChannel() {
    }

    public TextChannel(String name, String topic, boolean isNSFW) {
        super.setName(name);
        super.setTopic(topic);
        this.isNSFW = isNSFW;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNSFW() {
        return isNSFW;
    }

    public void setNSFW(boolean NSFW) {
        isNSFW = NSFW;
    }

    public Set<Long> getMessages() {
        return messages;
    }

    public void setMessages(Set<Long> messages) {
        this.messages = messages;
    }

    public Set<Long> getTags() {
        return super.getTags();
    }

    public void setTags(Set<Long> tags) {
        super.setTags(tags);
    }
}
