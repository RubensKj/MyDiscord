package com.mydiscord.Services;

import com.mydiscord.Exceptions.TextChannelNotExistsException;
import com.mydiscord.Exceptions.TextChannelWasNotFoundByIdException;
import com.mydiscord.Models.Channel;
import com.mydiscord.Models.TextChannel;
import com.mydiscord.Repositories.TextChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class TextChannelService {

    private final TextChannelRepository textChannelRepository;

    @Autowired
    public TextChannelService(TextChannelRepository textChannelRepository) {
        this.textChannelRepository = textChannelRepository;
    }

    public void edit(TextChannel textChannel) throws TextChannelNotExistsException {
        if (textChannel.getId() != null && textChannelRepository.existsById(textChannel.getId())) {
            textChannelRepository.save(textChannel);
        }
        throw new TextChannelNotExistsException("TextChannel not exists with this id.");
    }

    public TextChannel findById(Long id) throws TextChannelWasNotFoundByIdException {
        return textChannelRepository.findById(id).orElseThrow(() -> new TextChannelWasNotFoundByIdException("TextChannel was not found by id"));
    }

    public Set<Channel> findAllTextChannelsByIdsIn(Set<Long> ids) {
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
