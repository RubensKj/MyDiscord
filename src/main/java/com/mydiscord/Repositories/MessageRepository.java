package com.mydiscord.Repositories;

import com.mydiscord.Models.Message;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {
    void deleteAllByIdIn(Set<Long> ids);
}
