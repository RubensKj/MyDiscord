package com.mydiscord.Controllers;

import com.mydiscord.Exceptions.GuildNotFoundByIdException;
import com.mydiscord.Exceptions.UserNotFoundByIdException;
import com.mydiscord.Helpers.GuildHelper;
import com.mydiscord.Models.Guild;
import com.mydiscord.Payloads.GuildPayload;
import com.mydiscord.Services.AccountService;
import com.mydiscord.Services.GuildService;
import com.mydiscord.Services.TagService;
import com.mydiscord.Services.TextChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class GuildController {

    @Autowired
    private GuildService guildService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TextChannelService textChannelService;

    @Autowired
    private TagService tagService;

    @PostMapping("/guild/create")
    public ResponseEntity<Guild> createGuild(@Valid @RequestBody GuildPayload payloadGuild) throws UserNotFoundByIdException {
        if (accountService.existsById(payloadGuild.getIdOwner())) {
            Guild guild = new GuildHelper(textChannelService, tagService).buildStandardModel(payloadGuild);
            guildService.save(guild);
            return ResponseEntity.ok(guild);
        }
        throw new UserNotFoundByIdException("User's id wasn't found. Not possible to create a guild without user id");
    }

    @DeleteMapping("/guild/delete/{id}")
    public ResponseEntity<?> deleteGuildById(@PathVariable("id") Long id) throws GuildNotFoundByIdException {
        if (guildService.existsById(id)) {
            Guild guild = guildService.findById(id);
            new GuildHelper(textChannelService, tagService).deleteGuildChannelsAndTags(guild);
            guildService.deleteById(guild.getId());
            return new ResponseEntity<>("Guild was delete successfully",
                    HttpStatus.OK);
        }
        return new ResponseEntity<>("Guild wasn't found with this id",
                HttpStatus.NOT_FOUND);
    }

    @GetMapping("/adm/guilds/{page}")
    public Page<Guild> returnAllGuilds(@PathVariable("page") int page) {
        return guildService.guildsPage(PageRequest.of(page, 10));
    }
}
