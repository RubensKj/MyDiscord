package com.mydiscord.Helpers;

import com.mydiscord.Exceptions.TextChannelNameAlreayExistsException;
import com.mydiscord.Models.TextChannel;
import com.mydiscord.Payloads.TextChannelPayload;
import com.mydiscord.Services.GuildService;
import com.mydiscord.Services.TextChannelService;

import java.util.ArrayList;
import java.util.List;

public class TextChannelHelper {

    private TextChannelService textChannelService;

    private GuildService guildService;

    public TextChannelHelper(TextChannelService textChannelService, GuildService guildService) {
        this.textChannelService = textChannelService;
        this.guildService = guildService;
    }

    public TextChannel createTextChannel(TextChannelPayload payload, Long defaultTagId, boolean isNameExists) throws TextChannelNameAlreayExistsException {
        if (!isNameExists) {
            TextChannel textChannel = new TextChannel(payload.getName(), payload.getTopic(), payload.isNSFW());
            textChannel.setTags(returnListWithStandardTagIdInside(defaultTagId));
            textChannelService.save(textChannel);
            return textChannel;
        }
        throw new TextChannelNameAlreayExistsException("TextChannel name already exists (" + payload.getName() + ")");
    }

    private List<Long> returnListWithStandardTagIdInside(Long standardTagId) {
        List<Long> listIdsTag = new ArrayList<>();
        listIdsTag.add(standardTagId);
        return listIdsTag;
    }
}
