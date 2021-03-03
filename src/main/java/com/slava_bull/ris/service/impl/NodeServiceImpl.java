package com.slava_bull.ris.service.impl;

import com.slava_bull.ris.common.service.impl.CommonCrudService;
import com.slava_bull.ris.model.Node;
import com.slava_bull.ris.repository.NodeRepository;
import com.slava_bull.ris.service.NodeService;
import org.springframework.stereotype.Service;

@Service
public class NodeServiceImpl
        extends CommonCrudService<Node, NodeRepository>
        implements NodeService {

    public NodeServiceImpl(NodeRepository repository) {
        super(repository);
    }
}
