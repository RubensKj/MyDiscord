package com.mydiscord.Payloads;

import com.mydiscord.Models.Channel;
import com.mydiscord.Models.Guild;

import java.util.Set;

public class GuildParseJson {

    private Long id;

    private Long idOwner;

    private String name;

    private String avatar;

    private Set<Long> tags;

    private Set<Channel> channels;

    private Set<Long> members;

    private Set<Long> bans;

    private Set<Long> inviteLinks;

    public GuildParseJson(Guild guild, Set<Channel> channels) {
        this.id = guild.getId();
        this.idOwner = guild.getOwner();
        this.name = guild.getName();
        this.avatar = guild.getAvatar();
        this.tags = guild.getTags();
        this.channels = channels;
        this.members = guild.getMembers();
        this.bans = guild.getBans();
        this.inviteLinks = guild.getInviteLinks();
    }

    public Long getId() {
        return id;
    }

    public Long getIdOwner() {
        return idOwner;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public Set<Long> getTags() {
        return tags;
    }

    public Set<Channel> getChannels() {
        return channels;
    }

    public Set<Long> getMembers() {
        return members;
    }

    public Set<Long> getBans() {
        return bans;
    }

    public Set<Long> getInviteLinks() {
        return inviteLinks;
    }
}
