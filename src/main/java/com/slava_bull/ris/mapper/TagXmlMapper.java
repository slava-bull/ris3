package com.slava_bull.ris.mapper;

import com.slava_bull.ris.model.Node;
import com.slava_bull.ris.model.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagXmlMapper {

    public Tag map(com.slava_bull.Tag tagXml, Node node) {
        Tag tag = new Tag();
        tag.setNode(node);
        tag.setKey(tagXml.getK());
        tag.setValue(tagXml.getV());
        return tag;
    }
}
