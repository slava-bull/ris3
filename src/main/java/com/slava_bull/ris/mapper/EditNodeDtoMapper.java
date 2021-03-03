package com.slava_bull.ris.mapper;

import com.slava_bull.ris.common.mapper.impl.CommonMapper;
import com.slava_bull.ris.dto.EditNodeDto;
import com.slava_bull.ris.model.Node;
import org.springframework.stereotype.Component;

@Component
public class EditNodeDtoMapper extends CommonMapper<Node, EditNodeDto> {
    public EditNodeDtoMapper() {
        super(Node.class, EditNodeDto.class);
    }
}
