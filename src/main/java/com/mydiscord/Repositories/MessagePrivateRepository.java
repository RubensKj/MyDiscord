package com.mydiscord.Repositories;

import com.mydiscord.Models.MessagePrivate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagePrivateRepository extends PagingAndSortingRepository<MessagePrivate, Long> {
}
