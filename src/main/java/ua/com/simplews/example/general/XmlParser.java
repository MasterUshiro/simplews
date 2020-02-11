package ua.com.simplews.example.general;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlParser {

    @Test
    void test() {

        try {
            // create new `Document`
            DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document dom = builder.newDocument();

            // first create root element
            Element root = dom.createElement("user");
            dom.appendChild(root);

            // set `id` attribute to root element
            Attr attr = dom.createAttribute("id");
            attr.setValue("1");
            root.setAttributeNode(attr);

            // now create child elements (name, email, phone)
            Element name = dom.createElement("name");
            name.setTextContent("John Deo");
            Element email = dom.createElement("email");
            email.setTextContent("john.doe@example.com");
            Element phone = dom.createElement("phone");
            phone.setTextContent("800 456-4578");

            // add child nodes to root node
            root.appendChild(name);
            root.appendChild(email);
            root.appendChild(phone);

            // write DOM to XML file
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.transform(new DOMSource(dom), new StreamResult(new File("file.xml")));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
