package com.mydiscord.Controllers;

import com.mydiscord.Exceptions.TextChannelWasNotFoundByIdException;
import com.mydiscord.Helpers.MessageHelper;
import com.mydiscord.Models.MessageGuild;
import com.mydiscord.Models.TextChannel;
import com.mydiscord.Payloads.MessageGuildPayload;
import com.mydiscord.Services.ChannelService;
import com.mydiscord.Services.MessageService;
import com.mydiscord.Services.TextChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private TextChannelService textChannelService;

    @PostMapping("/textchannel/{id}/create/message")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<MessageGuild> createMessageAndStoreInTextChannelMessages(@PathVariable("id") Long id, @Valid @RequestBody MessageGuildPayload messagePayload) throws TextChannelWasNotFoundByIdException {
        if (channelService.existsById(id)) {
            TextChannel textChannel = textChannelService.findById(id);
            MessageGuild message = new MessageHelper(messageService, channelService).createMessageGuildAndAddInTextChannelsMessages(textChannel, messagePayload);
            return ResponseEntity.ok(message);
        }
        throw new TextChannelWasNotFoundByIdException("TextChannel was not found by id");
    }
}
