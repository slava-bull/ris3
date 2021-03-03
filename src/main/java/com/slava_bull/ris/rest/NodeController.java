package com.slava_bull.ris.rest;

import com.slava_bull.ris.common.rest.impl.CommonCrudController;
import com.slava_bull.ris.dto.EditNodeDto;
import com.slava_bull.ris.dto.SaveNodeDto;
import com.slava_bull.ris.jaxb.NodeJaxbParser;
import com.slava_bull.ris.mapper.EditNodeDtoMapper;
import com.slava_bull.ris.mapper.NodeXmlMapper;
import com.slava_bull.ris.mapper.SaveNodeDtoMapper;
import com.slava_bull.ris.model.Node;
import com.slava_bull.ris.service.NodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/node")
public class NodeController extends CommonCrudController<
        Node,
        SaveNodeDto,
        SaveNodeDtoMapper,
        EditNodeDto,
        EditNodeDtoMapper,
        NodeService> {

    private final NodeXmlMapper nodeXmlMapper;

    public NodeController(NodeService service, SaveNodeDtoMapper saveMapper, EditNodeDtoMapper editMapper, NodeXmlMapper nodeXmlMapper) {
        super(service, saveMapper, editMapper);
        this.nodeXmlMapper = nodeXmlMapper;
    }

    @PostMapping("/init")
    public void init() {
        new Thread(() -> {
            NodeJaxbParser parser = new NodeJaxbParser();
            List<Node> nodeList = new ArrayList<>();
            try {
                parser.findNodes("src/main/resources/osm.xml", node -> nodeList.add(nodeXmlMapper.map(node)));
            } catch (Exception exception) {
                log.error(exception.getLocalizedMessage());
            }
            log.info("End parsing");
            service.saveAll(nodeList.subList(0, 1000));
            log.info("End saving");
        }).start();
    }
}
