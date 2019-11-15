package com.mydiscord.Services;

import com.mydiscord.Models.TextChannel;
import com.mydiscord.Repositories.TextChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class TextChannelService {

    @Autowired
    private TextChannelRepository textChannelRepository;

    public void save(TextChannel textChannel) {
        textChannelRepository.save(textChannel);
    }

    public Set<TextChannel> findAllTextChannelsByIdsIn(Set<Long> ids) {
        return textChannelRepository.findTextChannelsByIdIn(ids);
    }

    public boolean existsNameInTextChannels(String name, Set<Long> ids) {
        return textChannelRepository.existsByIdInAndNameEquals(ids, name);
    }

    public boolean existsById(Long id) {
        return textChannelRepository.existsById(id);
    }

    public void deleleById(Long id) {
        textChannelRepository.deleteById(id);
    }

    @Transactional
    public void deleteAllTextChannelsByIds(Set<Long> ids) {
        textChannelRepository.deleteAllByIdIn(ids);
    }
}
