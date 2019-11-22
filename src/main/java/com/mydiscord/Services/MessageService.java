package com.mydiscord.Services;

import com.mydiscord.Exceptions.MessageNotFoundByIdException;
import com.mydiscord.Models.Message;
import com.mydiscord.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void save(Message message) {
        messageRepository.save(message);
    }

    public void deleteAllInsideList(Set<Long> ids) {
        messageRepository.deleteAllByIdIn(ids);
    }

    public Message findById(Long id) throws MessageNotFoundByIdException {
        return messageRepository.findById(id).orElseThrow(() -> new MessageNotFoundByIdException("Message was not found by id."));
    }

}
