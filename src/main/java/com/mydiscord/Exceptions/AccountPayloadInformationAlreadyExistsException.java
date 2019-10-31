package com.mydiscord.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountPayloadInformationAlreadyExistsException extends Exception {
    public AccountPayloadInformationAlreadyExistsException(String message) {
        super(message);
    }
}
