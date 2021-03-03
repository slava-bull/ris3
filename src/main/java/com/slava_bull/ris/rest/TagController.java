package com.slava_bull.ris.rest;

import com.slava_bull.ris.common.rest.impl.CommonCrudController;
import com.slava_bull.ris.dto.EditTagDto;
import com.slava_bull.ris.dto.SaveTagDto;
import com.slava_bull.ris.mapper.EditTagDtoMapper;
import com.slava_bull.ris.mapper.SaveTagDtoMapper;
import com.slava_bull.ris.model.Tag;
import com.slava_bull.ris.service.TagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagController extends CommonCrudController<
        Tag,
        SaveTagDto,
        SaveTagDtoMapper,
        EditTagDto,
        EditTagDtoMapper,
        TagService> {
    
    public TagController(TagService service, SaveTagDtoMapper saveMapper, EditTagDtoMapper editMapper) {
        super(service, saveMapper, editMapper);
    }
}
