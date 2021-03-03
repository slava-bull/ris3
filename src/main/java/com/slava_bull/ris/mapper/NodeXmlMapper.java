package com.slava_bull.ris.mapper;

import com.slava_bull.ris.model.Node;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NodeXmlMapper {

    private final TagXmlMapper tagMapper;

    public Node map(com.slava_bull.Node nodeXml) {
        Node node = new Node();
        node.setId(nodeXml.getId().longValue());
        node.setLat(nodeXml.getLat());
        node.setLon(nodeXml.getLon());
        node.setUser(nodeXml.getUser());
        node.setTags(nodeXml.getTag().stream()
                .map(t -> tagMapper.map(t, node))
                .collect(Collectors.toList()));
        return node;
    }
}
