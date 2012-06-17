package amazclient.xmlmodel;

import amazclient.util.Md5Util;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;

/**
 * Unit test for simple App.
 */
public class modelTest extends TestCase {

    public void test1() throws JAXBException, IOException {
        //用xmlmodel类所在的包创建一个 JAXBContext
        JAXBContext jaxbContext = JAXBContext.newInstance("amazclient.xmlmodel");
        //生成model
        final Shoes shoes = new Shoes();
        shoes.setClothingType("1");
        shoes.setVariationData(new Shoes.VariationData());
        Shoes.ClassificationData classificationData = new Shoes.ClassificationData();
        shoes.setClassificationData(classificationData);

        //输出model的字符串形式到输出流
        final Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(shoes, System.out);


    }

    public void test2() throws IOException {
        final PipedOutputStream out = new PipedOutputStream();
        final PipedInputStream in = new PipedInputStream(out);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    out.write("aaaaaaaaaaa".getBytes());
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }).start();

        String md5Str = Md5Util.computeContentMD5Header(in);

        System.out.println(md5Str);
    }
}
