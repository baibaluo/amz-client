package amazclient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.PipedInputStream;

/**
 * User: Luo
 * Date: 12-6-17
 * Time: 下午11:43
 * 工具类，直接将JAXB对象转化为输入流
 */
public class MarshallerUtil {
    static Log log = LogFactory.getLog(MarshallerUtil.class);
    public static PipedInputStream getIn(JAXBContext jaxbContext, Object obj) {
        PipedInputStream in = null;
        try {
            MarshallerWriter marshallerWriter = new MarshallerWriter(jaxbContext, obj);
            in = marshallerWriter.getIn();
            marshallerWriter.start();
        } catch (JAXBException e) {
            log.error("", e);
        } catch (IOException e) {
            log.error("", e);
        }
        return in;
    }
}
