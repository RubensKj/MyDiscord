package com.mydiscord.Services;

import com.mydiscord.Models.TextChannel;
import com.mydiscord.Repositories.TextChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TextChannelService {

    @Autowired
    private TextChannelRepository textChannelRepository;

    public void save(TextChannel textChannel) {
        textChannelRepository.save(textChannel);
    }

    @Transactional
    public void deleteAllTextChannelsByIds(List<Long> ids) {
        textChannelRepository.deleteAllByIdIn(ids);
    }
}
