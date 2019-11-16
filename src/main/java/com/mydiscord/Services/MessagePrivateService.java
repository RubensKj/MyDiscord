package com.mydiscord.Services;

import com.mydiscord.Exceptions.MessageNotFoundByIdException;
import com.mydiscord.Models.MessagePrivate;
import com.mydiscord.Repositories.MessagePrivateRepository;
import com.mydiscord.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagePrivateService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessagePrivateRepository messagePrivateRepository;

    public MessagePrivate findById(Long id) throws MessageNotFoundByIdException {
        return messagePrivateRepository.findById(id).orElseThrow(() -> new MessageNotFoundByIdException("Message was not found by id"));
    }
}
