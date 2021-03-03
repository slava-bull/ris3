package com.slava_bull.ris.service;

import com.slava_bull.ris.common.service.CrudService;
import com.slava_bull.ris.dto.NearPointDto;
import com.slava_bull.ris.model.Node;

import java.util.List;

public interface NodeService extends CrudService<Node> {
    void saveAll(List<Node> nodeList);

    List<Node> getNear(NearPointDto nearPointDto);
}
