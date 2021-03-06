package com.slava_bull.ris.jaxb;

import com.slava_bull.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.util.function.Consumer;

public class NodeJaxbParser {

    public void findNodes(String fileName, Consumer<Node> nodeFunction) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(com.slava_bull.ObjectFactory.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setListener(new Unmarshaller.Listener() {
            @Override
            public void afterUnmarshal(Object target, Object parent) {
                if (target instanceof Node) {
                    nodeFunction.accept((Node) target);
                }
                super.afterUnmarshal(target, parent);
            }
        });
        unmarshaller.unmarshal(new FileInputStream(fileName));
    }
}
