package com.slava_bull.ris.service.impl;

import com.slava_bull.ris.common.service.impl.CommonCrudService;
import com.slava_bull.ris.model.Tag;
import com.slava_bull.ris.repository.TagRepository;
import com.slava_bull.ris.service.TagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl
        extends CommonCrudService<Tag, TagRepository>
        implements TagService {

    public TagServiceImpl(TagRepository repository) {
        super(repository);
    }
}
