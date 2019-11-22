package com.mydiscord.Services;

import com.mydiscord.Exceptions.GuildNotFoundByIdException;
import com.mydiscord.Models.Guild;
import com.mydiscord.Repositories.GuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GuildService {

    private final GuildRepository guildRepository;

    @Autowired
    public GuildService(GuildRepository guildRepository) {
        this.guildRepository = guildRepository;
    }

    public void save(Guild guild) {
        guildRepository.save(guild);
    }

    public void deleteById(Long id) {
        guildRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return guildRepository.existsById(id);
    }

    public Guild findById(Long id) throws GuildNotFoundByIdException {
        return guildRepository.findById(id).orElseThrow(() -> new GuildNotFoundByIdException("Any Guild was found with this id"));
    }

    public Page<Guild> guildsPage(Pageable pageable) {
        return guildRepository.findAll(pageable);
    }
}
