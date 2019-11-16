package com.mydiscord.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MessageNotFoundByIdException extends Exception {
    public MessageNotFoundByIdException(String message) {
        super(message);
    }
}
