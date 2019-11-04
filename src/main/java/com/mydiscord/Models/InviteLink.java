package com.mydiscord.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class InviteLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String idOfServer;

    private String createdBy;

    private String channelInvited;

    private Date expires;

    private int uses;

    public InviteLink() {
    }

    public InviteLink(String idOfServer, String createdBy, String channelInvited) {
        this.idOfServer = idOfServer;
        this.createdBy = createdBy;
        this.channelInvited = channelInvited;
    }

    public InviteLink(String idOfServer, String createdBy, String channelInvited, Date expires) {
        this.idOfServer = idOfServer;
        this.createdBy = createdBy;
        this.channelInvited = channelInvited;
        this.expires = expires;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdOfServer() {
        return idOfServer;
    }

    public void setIdOfServer(String idOfServer) {
        this.idOfServer = idOfServer;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getChannelInvited() {
        return channelInvited;
    }

    public void setChannelInvited(String channelInvited) {
        this.channelInvited = channelInvited;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }
}
