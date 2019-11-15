package com.mydiscord.Controllers;

import com.mydiscord.Exceptions.GuildNotFoundByIdException;
import com.mydiscord.Exceptions.TagNotFoundException;
import com.mydiscord.Exceptions.TextChannelNameAlreayExistsException;
import com.mydiscord.Exceptions.TextChannelWasNotFoundByIdException;
import com.mydiscord.Helpers.GuildHelper;
import com.mydiscord.Helpers.TextChannelHelper;
import com.mydiscord.Models.Guild;
import com.mydiscord.Models.TextChannel;
import com.mydiscord.Payloads.TextChannelPayload;
import com.mydiscord.Services.GuildService;
import com.mydiscord.Services.TagService;
import com.mydiscord.Services.TextChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class TextChannelController {

    @Autowired
    private TextChannelService textChannelService;

    @Autowired
    private GuildService guildService;

    @Autowired
    private TagService tagService;

    @PostMapping("/create/textchannel/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<TextChannel> createTextChannelInGuild(@PathVariable("id") Long id, @Valid @RequestBody TextChannelPayload textChannelPayload) throws GuildNotFoundByIdException, TagNotFoundException, TextChannelNameAlreayExistsException {
        if (guildService.existsById(id)) {
            Guild guild = guildService.findById(id);
            TextChannel textChannel = new TextChannelHelper(textChannelService)
                    .createTextChannelAndSave(textChannelPayload,
                            tagService.findTagStandardInsideList(guild.getTags()).getId(),
                            textChannelService.existsNameInTextChannels(textChannelPayload.getName(), guild.getTextChannels()));
            guild = new GuildHelper(guildService, textChannelService).addTextChannelIdInGuild(guild, textChannel.getId());
            guildService.save(guild);
            return ResponseEntity.ok(textChannel);
        }
        throw new GuildNotFoundByIdException("Guild wasn't found with this id");
    }

    @DeleteMapping("/delete/textchannel/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteTextChannelById(@PathVariable("id") Long id) throws TextChannelWasNotFoundByIdException {
        if (textChannelService.existsById(id)) {
            textChannelService.deleleById(id);

            // Delete messages here. (need a method)

            return new ResponseEntity<>("Text Channel deleted successfully.",
                    HttpStatus.OK);
        }
        throw new TextChannelWasNotFoundByIdException("Text Channel was not found by id.");
    }
}
