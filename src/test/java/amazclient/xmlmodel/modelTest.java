package amazclient.xmlmodel;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.PrintWriter;
import java.math.BigDecimal;

/**
 * Unit test for simple App.
 */
public class modelTest
        extends TestCase {

    public void test1() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance("amazclient.xmlmodel");

        Shoes shoes = new Shoes();
        shoes.setClothingType("1");
        shoes.setVariationData(new Shoes.VariationData());
        Shoes.ClassificationData classificationData = new Shoes.ClassificationData();

        shoes.setClassificationData(classificationData);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(shoes, System.out);

        System.out.println(shoes);
    }
}
