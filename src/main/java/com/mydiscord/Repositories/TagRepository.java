package com.mydiscord.Repositories;

import com.mydiscord.Models.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
    void deleteAllByIdIn(List<Long> ids);
    Optional<Tag> findByIdInAndNameEquals(List<Long> ids, String name);
}
