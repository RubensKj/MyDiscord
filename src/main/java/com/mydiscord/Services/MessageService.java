package com.mydiscord.Services;

import com.mydiscord.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void deleteAllInsideList(Set<Long> ids) {
        messageRepository.deleteAllByIdIn(ids);
    }
}
