package com.mydiscord.Payloads;

import org.springframework.web.multipart.MultipartFile;

public class GuildPayload {

    private Long idOwner;

    private String name;

    private MultipartFile multipartFileAvatar;

    public Long getIdOwner() {
        return idOwner;
    }

    public String getName() {
        return name;
    }

    public MultipartFile getMultipartFileAvatar() {
        return multipartFileAvatar;
    }
}
