package com.mydiscord.Repositories;

import com.mydiscord.Models.Guild;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuildRepository extends PagingAndSortingRepository<Guild, Long> {
}
