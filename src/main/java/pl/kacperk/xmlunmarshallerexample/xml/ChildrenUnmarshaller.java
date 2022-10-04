package pl.kacperk.xmlunmarshallerexample.xml;

import pl.kacperk.xmlunmarshallerexample.entity.Children;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.IOException;

public class ChildrenUnmarshaller {

    public Children unmarshall() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Children.class);
        String xmlFile = "./xmldata/popular_baby_names.xml";
        return (Children) context.createUnmarshaller().unmarshal(new FileReader(xmlFile));
    }
}
