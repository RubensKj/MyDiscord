package com.mydiscord.Helpers;

import com.mydiscord.Exceptions.TextChannelNameAlreayExistsException;
import com.mydiscord.Models.TextChannel;
import com.mydiscord.Payloads.TextChannelPayload;
import com.mydiscord.Services.TextChannelService;

import java.util.HashSet;
import java.util.Set;

public class TextChannelHelper {

    private TextChannelService textChannelService;

    public TextChannelHelper(TextChannelService textChannelService) {
        this.textChannelService = textChannelService;
    }

    public TextChannel createTextChannelAndSave(TextChannelPayload payload, Long defaultTagId, boolean isNameExists) throws TextChannelNameAlreayExistsException {
        if (!isNameExists) {
            TextChannel textChannel = new TextChannel(payload.getName(), payload.getTopic(), payload.isNSFW());
            textChannel.setTags(returnListWithStandardTagIdInside(defaultTagId));
            textChannelService.save(textChannel);
            return textChannel;
        }
        throw new TextChannelNameAlreayExistsException("TextChannel name already exists (" + payload.getName() + ")");
    }

    private Set<Long> returnListWithStandardTagIdInside(Long standardTagId) {
        Set<Long> listIdsTag = new HashSet<>();
        listIdsTag.add(standardTagId);
        return listIdsTag;
    }
}
