package com.mydiscord.Services;

import com.mydiscord.Exceptions.ChannelNotFoundById;
import com.mydiscord.Models.Channel;
import com.mydiscord.Repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public void save(Channel channel) {
        channelRepository.save(channel);
    }

    public Page<Channel> findAllChannelsInListIdsPageable(Set<Long> ids, Pageable pageable) {
        return channelRepository.findChannelsByIdIn(ids, pageable);
    }

    public Channel findById(Long id) throws ChannelNotFoundById {
        return channelRepository.findById(id).orElseThrow(() -> new ChannelNotFoundById("Channel was not found by id."));
    }

    public boolean existsById(Long id) {
        return channelRepository.existsById(id);
    }
}
