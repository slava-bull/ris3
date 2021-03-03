package com.slava_bull.ris.mapper;

import com.slava_bull.ris.common.mapper.impl.CommonMapper;
import com.slava_bull.ris.dto.SaveTagDto;
import com.slava_bull.ris.model.Tag;
import com.slava_bull.ris.service.NodeService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SaveTagDtoMapper extends CommonMapper<Tag, SaveTagDto> {

    private final NodeService nodeService;

    public SaveTagDtoMapper(NodeService nodeService) {
        super(Tag.class, SaveTagDto.class);
        this.nodeService = nodeService;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Tag.class, SaveTagDto.class)
                .addMappings(m -> m.skip(SaveTagDto::setNodeId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(SaveTagDto.class, Tag.class)
                .addMappings(m -> m.skip(Tag::setNode)).setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(Tag source, SaveTagDto destination) {
        destination.setNodeId(source.getNode().getId());
    }

    @Override
    protected void mapSpecificFields(SaveTagDto source, Tag destination) {
        destination.setNode(nodeService.getById(source.getNodeId()));
    }
}
