package com.mydiscord.Payloads;

public class TextChannelPayload {

    private String name;

    private String topic;

    private boolean nsfw;

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    public boolean isNSFW() {
        return nsfw;
    }
}
