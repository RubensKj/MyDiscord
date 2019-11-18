package com.mydiscord.Helpers;

import com.mydiscord.Exceptions.TagNotFoundException;
import com.mydiscord.Exceptions.UserNotFoundByIdException;
import com.mydiscord.Models.*;
import com.mydiscord.Payloads.GuildPayload;
import com.mydiscord.Services.*;

import java.util.HashSet;
import java.util.Set;

public class GuildHelper {

    private ChannelService channelService;

    private TextChannelService textChannelService;

    private TagService tagService;

    private MemberService memberService;

    private UserService userService;

    public GuildHelper() {
    }

    public GuildHelper(TextChannelService textChannelService) {
        this.textChannelService = textChannelService;
    }

    public GuildHelper(TextChannelService textChannelService, TagService tagService) {
        this.textChannelService = textChannelService;
        this.tagService = tagService;
    }

    public GuildHelper(MemberService memberService, TagService tagService) {
        this.memberService = memberService;
        this.tagService = tagService;
    }

    public GuildHelper(TextChannelService textChannelService, TagService tagService, MemberService memberService, UserService userService) {
        this.textChannelService = textChannelService;
        this.tagService = tagService;
        this.memberService = memberService;
        this.userService = userService;
    }

    public GuildHelper(ChannelService channelService, TagService tagService, MemberService memberService, UserService userService) {
        this.channelService = channelService;
        this.tagService = tagService;
        this.memberService = memberService;
        this.userService = userService;
    }

    public Guild buildStandardModel(GuildPayload guildPayload) throws UserNotFoundByIdException {
        Guild guild = new Guild(guildPayload.getIdOwner(), guildPayload.getName(), "");
        Set<Long> standardTags = returnListWithStandardTags();
        guild.setTags(standardTags);
        guild.setChannels(returnStandardTextChannelsIdsWithTagsSeted(standardTags));
        guild.setMembers(returnMembersIdsWithTags(guildPayload.getIdOwner(), standardTags));
        return guild;
    }

    // Submethods of buildStandardModel
    private Set<Long> returnStandardTextChannelsIdsWithTagsSeted(Set<Long> standardTags) {
        Set<Long> listIdWithStandardTextChannelId = new HashSet<>();
        listIdWithStandardTextChannelId.add(createTextChannelWithStandardTags(standardTags).getId());
        return listIdWithStandardTextChannelId;
    }

    private TextChannel createTextChannelWithStandardTags(Set<Long> standardTags) {
        TextChannel textChannelStandard = new TextChannel("general", "", false);
        textChannelStandard.setTags(standardTags);
        channelService.save(textChannelStandard);
        return textChannelStandard;
    }

    private Set<Long> returnMembersIdsWithTags(Long idUser, Set<Long> standardTags) throws UserNotFoundByIdException {
        Set<Long> idsMembers = new HashSet<>();
        Member member = createOwnerIntoMember(userService.findById(idUser), standardTags);
        idsMembers.add(member.getId());
        return idsMembers;
    }

    private Member createOwnerIntoMember(User user, Set<Long> standardTags) {
        Member member = new Member(user, "", standardTags, true);
        memberService.save(member);
        return member;
    }

    private Set<Long> returnListWithStandardTags() {
        Set<Long> idTags = new HashSet<>();
        idTags.add(createAndSaveTag().getId());
        return idTags;
    }

    private Tag createAndSaveTag() {
        Tag guildStandardTag = new Tag("everyone", "#ffffff", new TagSettings(true, true, Permissions.UNKNOWN));
        tagService.saveTagAndTagSettings(guildStandardTag);
        return guildStandardTag;
    }

    // Delete method
    public void deleteGuildChannelsAndTags(Guild guild) {
        textChannelService.deleteAllTextChannelsByIds(guild.getChannels());
        tagService.deleteAllTagsByIds(guild.getTags());
    }

    // add id in guild textChannels ids.
    public Guild addTextChannelIdInGuild(Guild guild, Long id) {
        guild.setChannels(returnListOfTextChannelIdWithNewOne(guild, id));
        return guild;
    }

    // Submethods of addTextChannelIdInGuild
    private Set<Long> returnListOfTextChannelIdWithNewOne(Guild guild, Long id) {
        Set<Long> textChannelsIds = guild.getChannels();
        textChannelsIds.add(id);
        return textChannelsIds;
    }

    // Submethods of createAndAddMemberIntoGuild
    public Member createMemberWithStandardTags(User user, Set<Long> tagsIdOfGuild) throws TagNotFoundException {
        Tag tagStandardInsideList = tagService.findTagStandardInsideList(tagsIdOfGuild);
        Member member = new Member(user, "", returnListTagWithThisTag(tagStandardInsideList), false);
        memberService.save(member);
        return member;
    }

    private Set<Long> returnListTagWithThisTag(Tag tag) {
        Set<Long> tagsId = new HashSet<>();
        tagsId.add(tag.getId());
        return tagsId;
    }
}
