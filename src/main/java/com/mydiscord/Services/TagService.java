package com.mydiscord.Services;

import com.mydiscord.Exceptions.TagNotFoundException;
import com.mydiscord.Models.Tag;
import com.mydiscord.Repositories.TagRepository;
import com.mydiscord.Repositories.TagSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagSettingsRepository tagSettingsRepository;

    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    public void saveTagAndTagSettings(Tag tag) {
        tagSettingsRepository.save(tag.getTagSettings());
        tagRepository.save(tag);
    }

    @Transactional
    public void deleteAllTagsByIds(List<Long> ids) {
        tagRepository.deleteAllByIdIn(ids);
    }

    public Tag findTagStandardInsideList(List<Long> ids) throws TagNotFoundException {
        return tagRepository.findByIdInAndNameEquals(ids, "everyone").orElseThrow(() -> new TagNotFoundException("Standard Tag was not found."));
    }
}
