package com.mydiscord.Repositories;

import com.mydiscord.Models.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
    void deleteAllByIdIn(List<Long> ids);
}
