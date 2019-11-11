package com.mydiscord.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class TagSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean isDiplayedTag;

    private boolean anyoneCanMention;

    @ElementCollection
    private List<Permissions> permissions;

    public TagSettings() {
    }

    public TagSettings(boolean isDiplayedTag, boolean anyoneCanMention, List<Permissions> permissions) {
        this.isDiplayedTag = isDiplayedTag;
        this.anyoneCanMention = anyoneCanMention;
        this.permissions = permissions;
    }

    public TagSettings(boolean isDiplayedTag, boolean anyoneCanMention, Permissions... permissions) {
        this.isDiplayedTag = isDiplayedTag;
        this.anyoneCanMention = anyoneCanMention;
        this.permissions = new ArrayList<>(Arrays.asList(permissions));
    }

    public Long getId() {
        return id;
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

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }
}
