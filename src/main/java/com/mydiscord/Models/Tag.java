package com.mydiscord.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String color;

    private boolean isDiplayedTag;

    private boolean anyoneCanMention;

    private boolean isAdministrator;

    public Tag() {
    }

    public Tag(String name, String color, boolean isDiplayedTag, boolean anyoneCanMention, boolean isAdministrator) {
        this.name = name;
        this.color = color;
        this.isDiplayedTag = isDiplayedTag;
        this.anyoneCanMention = anyoneCanMention;
        this.isAdministrator = isAdministrator;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDiplayedTag() {
        return isDiplayedTag;
    }

    public void setDiplayedTag(boolean diplayedTag) {
        isDiplayedTag = diplayedTag;
    }

    public boolean isAnyoneCanMention() {
        return anyoneCanMention;
    }

    public void setAnyoneCanMention(boolean anyoneCanMention) {
        this.anyoneCanMention = anyoneCanMention;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }
}
