package com.mydiscord.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CannotAddMemberException extends Exception {
    public CannotAddMemberException(String message) {
        super(message);
    }
}
