package com.mydiscord.Repositories;

import com.mydiscord.Models.TagSettings;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagSettingsRepository extends PagingAndSortingRepository<TagSettings, Long> {
}
