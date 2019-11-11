package com.mydiscord.Repositories;

import com.mydiscord.Models.TextChannel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextChannelRepository extends PagingAndSortingRepository<TextChannel, Long> {
    void deleteAllByIdIn(List<Long> ids);
}
