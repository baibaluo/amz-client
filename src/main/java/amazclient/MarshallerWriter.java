package amazclient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * User: Luo
 * Date: 12-6-15
 * Time: 下午20:12
 * 线程类，起动单独线程把输出流，转化为输入流
 */
public class MarshallerWriter extends Thread {
    Log log = LogFactory.getLog(this.getClass());
    private PipedOutputStream out = new PipedOutputStream();
    private PipedInputStream in = new PipedInputStream();
    private Marshaller marshaller;
    private Object obj;

    public MarshallerWriter(JAXBContext jaxbContext, Object obj) throws JAXBException, IOException {
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        this.obj = obj;
        in.connect(out);
    }

    public PipedInputStream getIn(){
        return in;
    }

    @Override
    public void run() {
        try {
            marshaller.marshal(obj, out);
            out.close();
        } catch (JAXBException e) {
            log.error("", e);
        } catch (IOException e) {
            log.error("", e);
        }
    }
}