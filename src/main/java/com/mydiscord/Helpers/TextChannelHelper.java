package com.mydiscord.Helpers;

import com.mydiscord.Exceptions.TextChannelNameAlreayExistsException;
import com.mydiscord.Models.TextChannel;
import com.mydiscord.Payloads.TextChannelPayload;
import com.mydiscord.Services.ChannelService;
import com.mydiscord.Services.MessageService;
import com.mydiscord.Services.TextChannelService;

import java.util.HashSet;
import java.util.Set;

public class TextChannelHelper {

    private ChannelService channelService;

    private TextChannelService textChannelService;

    private MessageService messageService;

    public TextChannelHelper(ChannelService channelService) {
        this.channelService = channelService;
    }

    public TextChannelHelper(TextChannelService textChannelService) {
        this.textChannelService = textChannelService;
    }

    public TextChannelHelper(MessageService messageService) {
        this.messageService = messageService;
    }

    public TextChannel createTextChannelAndSave(TextChannelPayload payload, Long defaultTagId, boolean isNameExists) throws TextChannelNameAlreayExistsException {
        if (!isNameExists) {
            TextChannel textChannel = new TextChannel(payload.getName(), payload.getTopic(), payload.isNSFW());
            textChannel.setTags(returnListWithStandardTagIdInside(defaultTagId));
            channelService.save(textChannel);
            return textChannel;
        }
        throw new TextChannelNameAlreayExistsException("TextChannel name already exists (" + payload.getName() + ")");
    }

    private Set<Long> returnListWithStandardTagIdInside(Long standardTagId) {
        Set<Long> listIdsTag = new HashSet<>();
        listIdsTag.add(standardTagId);
        return listIdsTag;
    }

    public void deleteMessagesFromTextChannel(Set<Long> idsFromMessages) {
        messageService.deleteAllInsideList(idsFromMessages);
    }
}
