package com.mydiscord.Helpers;

import com.mydiscord.Models.*;
import com.mydiscord.Payloads.GuildPayload;
import com.mydiscord.Services.TagService;
import com.mydiscord.Services.TextChannelService;

import java.util.ArrayList;
import java.util.List;

public class GuildHelper {

    private TextChannelService textChannelService;

    private TagService tagService;

    public GuildHelper(TextChannelService textChannelService, TagService tagService) {
        this.textChannelService = textChannelService;
        this.tagService = tagService;
    }

    public Guild buildStandardModel(GuildPayload guildPayload) {
        Guild guild = new Guild(guildPayload.getIdOwner(), guildPayload.getName(), "");
        guild.setTags(returnListWithStandardTags());
        guild.setTextChannels(returnListWithStandardTextChannelId());
        return guild;
    }

    // Submethods of buildStandardModel
    private List<Long> returnListWithStandardTextChannelId() {
        List<Long> listIdWithStandardTextChannelId = new ArrayList<>();
        listIdWithStandardTextChannelId.add(createTextChannelWithStandardTags().getId());
        return listIdWithStandardTextChannelId;
    }

    private TextChannel createTextChannelWithStandardTags() {
        TextChannel textChannelStandard = new TextChannel("general", "", false);
        textChannelStandard.setTags(returnListWithStandardTags());
        textChannelService.save(textChannelStandard);
        return textChannelStandard;
    }

    private List<Long> returnListWithStandardTags() {
        List<Long> idTags = new ArrayList<>();
        idTags.add(createAndSaveTag().getId());
        return idTags;
    }

    private Tag createAndSaveTag() {
        Tag guildStandardTag = new Tag("everyone", "#ffffff", new TagSettings(true, true, Permissions.UNKNOWN));
        tagService.saveTagAndTagSettings(guildStandardTag);
        return guildStandardTag;
    }

    public void deleteGuildChannelsAndTags(Guild guild) {
        textChannelService.deleteAllTextChannelsByIds(guild.getTextChannels());
        tagService.deleteAllTagsByIds(guild.getTags());
    }
}
