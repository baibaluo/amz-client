package amazclient.sample;

import amazclient.AmazonConfig;
import amazclient.MarshallerUtil;
import amazclient.util.Md5Util;
import amazclient.xmlmodel.Shoes;
import com.amazonaws.mws.MarketplaceWebService;
import com.amazonaws.mws.model.SubmitFeedRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * User: Luo
 * Date: 12-6-17
 * Time: 下午11:50
 */
public class SubmitFeedSample {
    static final Log log = LogFactory.getLog(SubmitFeedSample.class);

    public static void main(String[] args) throws JAXBException {
        MarketplaceWebService service = AmazonConfig.getMarketplaceWebService();

        SubmitFeedRequest request = new SubmitFeedRequest();
        request.setMerchant(AmazonConfig.sellerId);
        request.setFeedType("_POST_ITEM_DATA_");

        /*生成xml内容*/
        //用xmlmodel类所在的包创建一个 JAXBContext
        JAXBContext jaxbContext = JAXBContext.newInstance("amazclient.xmlmodel");
        //Marshaller用于输出model的字符串形式到输出流
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //生成model
        final Shoes shoes = new Shoes();
        shoes.setClothingType("1");
        shoes.setVariationData(new Shoes.VariationData());
        Shoes.ClassificationData classificationData = new Shoes.ClassificationData();
        shoes.setClassificationData(classificationData);


        //设置xmlFeedContent
        request.setFeedContent(MarshallerUtil.getIn(jaxbContext, shoes));

        //计算md5
        String md5Str = Md5Util.computeContentMD5Header(MarshallerUtil.getIn(jaxbContext, shoes));
        request.setContentMD5(md5Str);

        com.amazonaws.mws.samples.SubmitFeedSample.invokeSubmitFeed(service, request);
    }
}
