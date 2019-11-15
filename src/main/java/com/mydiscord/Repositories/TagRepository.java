package com.mydiscord.Repositories;

import com.mydiscord.Models.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
    void deleteAllByIdIn(Set<Long> ids);

    Optional<Tag> findByIdInAndNameEquals(Set<Long> ids, String name);
}
