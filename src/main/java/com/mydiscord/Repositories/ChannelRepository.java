package com.mydiscord.Repositories;

import com.mydiscord.Models.Channel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ChannelRepository extends PagingAndSortingRepository<Channel, Long> {
    void deleteAllByIdIn(Set<Long> ids);

    Page<Channel> findChannelsByIdIn(Set<Long> ids, Pageable pageable);

    boolean existsByIdInAndNameEquals(Set<Long> ids, String name);
}
