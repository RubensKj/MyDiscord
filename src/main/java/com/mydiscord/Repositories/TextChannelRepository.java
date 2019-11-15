package com.mydiscord.Repositories;

import com.mydiscord.Models.TextChannel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TextChannelRepository extends PagingAndSortingRepository<TextChannel, Long> {
    void deleteAllByIdIn(Set<Long> ids);

    Set<TextChannel> findTextChannelsByIdIn(Set<Long> ids);

    boolean existsByIdInAndNameEquals(Set<Long> ids, String name);
}
