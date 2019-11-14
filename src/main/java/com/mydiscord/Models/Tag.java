package com.mydiscord.Models;

import javax.persistence.*;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String color;

    @OneToOne(cascade = CascadeType.REMOVE)
    private TagSettings tagSettings;

    public Tag() {
    }

    public Tag(String name, String color, TagSettings tagSettings) {
        this.name = name;
        this.color = color;
        this.tagSettings = tagSettings;
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

    public TagSettings getTagSettings() {
        return tagSettings;
    }

    public void setTagSettings(TagSettings tagSettings) {
        this.tagSettings = tagSettings;
    }
}
