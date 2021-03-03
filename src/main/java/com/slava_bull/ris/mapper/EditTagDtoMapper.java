package com.slava_bull.ris.mapper;

import com.slava_bull.ris.common.mapper.impl.CommonMapper;
import com.slava_bull.ris.dto.EditTagDto;
import com.slava_bull.ris.model.Tag;
import com.slava_bull.ris.service.NodeService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EditTagDtoMapper extends CommonMapper<Tag, EditTagDto> {

    private final NodeService nodeService;

    public EditTagDtoMapper(NodeService nodeService) {
        super(Tag.class, EditTagDto.class);
        this.nodeService = nodeService;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Tag.class, EditTagDto.class)
                .addMappings(m -> m.skip(EditTagDto::setNodeId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(EditTagDto.class, Tag.class)
                .addMappings(m -> m.skip(Tag::setNode)).setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(Tag source, EditTagDto destination) {
        destination.setNodeId(source.getNode().getId());
    }

    @Override
    protected void mapSpecificFields(EditTagDto source, Tag destination) {
        destination.setNode(nodeService.getById(source.getNodeId()));
    }
}
