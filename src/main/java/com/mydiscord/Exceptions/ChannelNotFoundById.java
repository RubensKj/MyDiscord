package com.mydiscord.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ChannelNotFoundById extends Exception {
    public ChannelNotFoundById(String message) {
        super(message);
    }
}
