package com.mydiscord.Payloads;

import com.mydiscord.Models.Guild;
import com.mydiscord.Models.TextChannel;

import java.util.Set;

public class GuildParseJson {

    private Long id;

    private Long idOwner;

    private String name;

    private String avatar;

    private Set<Long> tags;

    private Set<TextChannel> textChannels;

    // Change to Voice Channel model.
    private Set<Long> voiceChannels;

    private Set<Long> members;

    private Set<Long> bans;

    private Set<Long> inviteLinks;

    public GuildParseJson(Guild guild, Set<TextChannel> textChannels) {
        this.id = guild.getId();
        this.idOwner = guild.getOwner();
        this.name = guild.getName();
        this.avatar = guild.getAvatar();
        this.tags = guild.getTags();
        this.textChannels = textChannels;
        // Change here too
        this.voiceChannels = guild.getVoiceChannels();
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

    public Set<TextChannel> getTextChannels() {
        return textChannels;
    }

    public Set<Long> getVoiceChannels() {
        return voiceChannels;
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
