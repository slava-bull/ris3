package com.slava_bull.ris.mapper;

import com.slava_bull.ris.common.mapper.impl.CommonMapper;
import com.slava_bull.ris.dto.SaveNodeDto;
import com.slava_bull.ris.model.Node;
import org.springframework.stereotype.Component;

@Component
public class SaveNodeDtoMapper extends CommonMapper<Node, SaveNodeDto> {
    public SaveNodeDtoMapper() {
        super(Node.class, SaveNodeDto.class);
    }
}
