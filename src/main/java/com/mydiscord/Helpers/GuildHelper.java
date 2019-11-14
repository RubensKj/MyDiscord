package com.mydiscord.Helpers;

import com.mydiscord.Models.*;
import com.mydiscord.Payloads.GuildPayload;
import com.mydiscord.Services.GuildService;
import com.mydiscord.Services.MemberService;
import com.mydiscord.Services.TagService;
import com.mydiscord.Services.TextChannelService;

import java.util.ArrayList;
import java.util.List;

public class GuildHelper {

    private GuildService guildService;

    private TextChannelService textChannelService;

    private TagService tagService;

    private MemberService memberService;

    public GuildHelper(GuildService guildService, TextChannelService textChannelService) {
        this.guildService = guildService;
        this.textChannelService = textChannelService;
    }

    public GuildHelper(TextChannelService textChannelService, TagService tagService) {
        this.textChannelService = textChannelService;
        this.tagService = tagService;
    }

    public GuildHelper(TextChannelService textChannelService, TagService tagService, MemberService memberService) {
        this.textChannelService = textChannelService;
        this.tagService = tagService;
        this.memberService = memberService;
    }

    public Guild buildStandardModel(GuildPayload guildPayload) {
        Guild guild = new Guild(guildPayload.getIdOwner(), guildPayload.getName(), "");
        List<Long> standardTags = returnListWithStandardTags();
        guild.setTags(standardTags);
        guild.setTextChannels(returnStandardTextChannelsIdsWithTagsSeted(standardTags));
        guild.setMembers(returnMembersIdsWithTags(guildPayload.getIdOwner(), standardTags));
        return guild;
    }

    // Submethods of buildStandardModel
    private List<Long> returnStandardTextChannelsIdsWithTagsSeted(List<Long> standardTags) {
        List<Long> listIdWithStandardTextChannelId = new ArrayList<>();
        listIdWithStandardTextChannelId.add(createTextChannelWithStandardTags(standardTags).getId());
        return listIdWithStandardTextChannelId;
    }

    private TextChannel createTextChannelWithStandardTags(List<Long> standardTags) {
        TextChannel textChannelStandard = new TextChannel("general", "", false);
        textChannelStandard.setTags(standardTags);
        textChannelService.save(textChannelStandard);
        return textChannelStandard;
    }

    private List<Long> returnMembersIdsWithTags(Long idUser, List<Long> standardTags) {
        List<Long> idsMembers = new ArrayList<>();
        Member member = createOwnerIntoMember(idUser, standardTags);
        idsMembers.add(member.getId());
        return idsMembers;
    }

    private Member createOwnerIntoMember(Long idUser, List<Long> standardTags) {
        Member member = new Member(idUser, "", standardTags, true);
        memberService.save(member);
        return member;
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

    // Delete method
    public void deleteGuildChannelsAndTags(Guild guild) {
        textChannelService.deleteAllTextChannelsByIds(guild.getTextChannels());
        tagService.deleteAllTagsByIds(guild.getTags());
    }

    // add id in guild textChannels ids.
    public Guild addTextChannelIdInGuild(Guild guild, Long id) {
        guild.setTextChannels(returnListOfTextChannelIdWithNewOne(guild, id));
        return guild;
    }

    // Submethods of addTextChannelIdInGuild
    private List<Long> returnListOfTextChannelIdWithNewOne(Guild guild, Long id) {
        List<Long> textChannelsIds = guild.getTextChannels();
        textChannelsIds.add(id);
        return textChannelsIds;
    }
}
