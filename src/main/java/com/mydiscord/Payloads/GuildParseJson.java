package com.mydiscord.Payloads;

import com.mydiscord.Models.Guild;
import com.mydiscord.Models.TextChannel;

import java.util.List;
import java.util.Set;

public class GuildParseJson {

    private Long id;

    private Long idOwner;

    private String name;

    private String avatar;

    private List<Long> tags;

    private List<TextChannel> textChannels;

    // Change to Voice Channel model.
    private List<Long> voiceChannels;

    private List<Long> members;

    private List<Long> bans;

    private Set<Long> inviteLinks;

    public GuildParseJson(Guild guild, List<TextChannel> textChannels) {
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

    public List<Long> getTags() {
        return tags;
    }

    public List<TextChannel> getTextChannels() {
        return textChannels;
    }

    public List<Long> getVoiceChannels() {
        return voiceChannels;
    }

    public List<Long> getMembers() {
        return members;
    }

    public List<Long> getBans() {
        return bans;
    }

    public Set<Long> getInviteLinks() {
        return inviteLinks;
    }
}
