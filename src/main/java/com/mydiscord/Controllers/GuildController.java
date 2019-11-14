package com.mydiscord.Controllers;

import com.mydiscord.Exceptions.GuildNotFoundByIdException;
import com.mydiscord.Exceptions.UserNotFoundByIdException;
import com.mydiscord.Helpers.GuildHelper;
import com.mydiscord.Models.Guild;
import com.mydiscord.Payloads.GuildPayload;
import com.mydiscord.Payloads.GuildParseJson;
import com.mydiscord.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    private MemberService memberService;

    @PostMapping("/guild/create")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Guild> createGuild(@Valid @RequestBody GuildPayload payloadGuild) throws UserNotFoundByIdException {
        if (accountService.existsById(payloadGuild.getIdOwner())) {
            Guild guild = new GuildHelper(textChannelService, tagService, memberService).buildStandardModel(payloadGuild);
            guildService.save(guild);
            return ResponseEntity.ok(guild);
        }
        throw new UserNotFoundByIdException("User's id wasn't found. Not possible to create a guild without user id");
    }

    @DeleteMapping("/guild/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteGuildById(@PathVariable("id") Long id) throws GuildNotFoundByIdException {
        if (guildService.existsById(id)) {
            Guild guild = guildService.findById(id);
            new GuildHelper(textChannelService, tagService).deleteGuildChannelsAndTags(guild);
            guildService.deleteById(guild.getId());
            return new ResponseEntity<>("Guild was delete successfully",
                    HttpStatus.OK);
        }
        throw new GuildNotFoundByIdException("Guild wasn't found with this id");
    }

    @GetMapping("/guilds/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<GuildParseJson> findGuildAndTextChannels(@PathVariable("id") Long id) throws GuildNotFoundByIdException {
        if (guildService.existsById(id)) {
            Guild guild = guildService.findById(id);
            return ResponseEntity.ok(new GuildParseJson(guild, textChannelService.findAllTextChannelsByIdsIn(guild.getTextChannels())));
        }
        throw new GuildNotFoundByIdException("Guild wasn't found with this id");
    }

    @GetMapping("/adm/guilds/{page}")
    @PreAuthorize("hasRole('ADMIN')")
    public Page<Guild> returnAllGuilds(@PathVariable("page") int page) {
        return guildService.guildsPage(PageRequest.of(page, 10));
    }
}
