package amazclient.sample;

import amazclient.AmazonConfig;
import com.amazonaws.mws.MarketplaceWebService;
import com.amazonaws.mws.model.GetFeedSubmissionListRequest;

/**
 * User: Luo
 * Date: 12-6-17
 * Time: 下午11:57
 */
public class GetFeedSubmissionListSample {
    public static void main(String... args) {

        MarketplaceWebService service = AmazonConfig.getMarketplaceWebService();
        GetFeedSubmissionListRequest request = new GetFeedSubmissionListRequest();
        request.setMerchant(AmazonConfig.sellerId);
        com.amazonaws.mws.samples.GetFeedSubmissionListSample.invokeGetFeedSubmissionList(service, request);

    }
}
