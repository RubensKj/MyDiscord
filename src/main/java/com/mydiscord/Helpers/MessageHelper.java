package com.mydiscord.Helpers;

import com.mydiscord.Models.MessageGuild;
import com.mydiscord.Models.TextChannel;
import com.mydiscord.Payloads.MessageGuildPayload;
import com.mydiscord.Services.ChannelService;
import com.mydiscord.Services.MessageService;

public class MessageHelper {

    private MessageService messageService;

    private ChannelService channelService;

    public MessageHelper() {
    }

    public MessageHelper(MessageService messageService, ChannelService channelService) {
        this.messageService = messageService;
        this.channelService = channelService;
    }

    public MessageGuild createMessageGuildAndAddInTextChannelsMessages(TextChannel channel, MessageGuildPayload messageGuildPayload) {
        MessageGuild messageGuild = createMessageGuildAndSave(messageGuildPayload);
        channel.getMessages().add(messageGuild.getId());
        channelService.save(channel);
        return messageGuild;
    }

    private MessageGuild createMessageGuildAndSave(MessageGuildPayload messageGuildPayload) {
        MessageGuild messageGuild = new MessageGuild(messageGuildPayload.getMember(), messageGuildPayload.getMessage());
        messageService.save(messageGuild);
        return messageGuild;
    }
}
