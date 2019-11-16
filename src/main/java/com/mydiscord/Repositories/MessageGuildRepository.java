package com.mydiscord.Repositories;

import com.mydiscord.Models.MessageGuild;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageGuildRepository extends PagingAndSortingRepository<MessageGuild, Long> {
}
