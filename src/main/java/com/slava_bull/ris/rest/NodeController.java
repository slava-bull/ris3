package com.slava_bull.ris.rest;

import com.slava_bull.ris.common.rest.impl.CommonCrudController;
import com.slava_bull.ris.dto.EditNodeDto;
import com.slava_bull.ris.dto.SaveNodeDto;
import com.slava_bull.ris.mapper.EditNodeDtoMapper;
import com.slava_bull.ris.mapper.SaveNodeDtoMapper;
import com.slava_bull.ris.model.Node;
import com.slava_bull.ris.service.NodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
        @RequestMapping("/node")
public class NodeController extends CommonCrudController<
        Node,
        SaveNodeDto,
        SaveNodeDtoMapper,
        EditNodeDto,
        EditNodeDtoMapper,
        NodeService> {

    public NodeController(NodeService service, SaveNodeDtoMapper saveMapper, EditNodeDtoMapper editMapper) {
        super(service, saveMapper, editMapper);
    }
}
