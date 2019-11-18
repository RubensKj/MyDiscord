package com.mydiscord.Payloads;

import com.mydiscord.Models.Member;

public class MessageGuildPayload {

    private Member member;

    private String message;

    public Member getMember() {
        return member;
    }

    public String getMessage() {
        return message;
    }
}
