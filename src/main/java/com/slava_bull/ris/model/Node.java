package com.slava_bull.ris.model;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Node {
    private long id;
    private double lat;
    private double lon;
    private String user;
    private List<Tag> tags;

    public static Node fromXml(com.slava_bull.Node nodeXml) {
        Node node = new Node();
        node.id = nodeXml.getId().longValue();
        node.lat = nodeXml.getLat();
        node.lon = nodeXml.getLon();
        node.user = nodeXml.getUser();
        node.tags = nodeXml.getTag().stream()
                .map(t -> Tag.fromXml(t, node.id))
                .collect(Collectors.toList());
        return node;
    }
}
