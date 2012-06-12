package amazclient;

import com.amazonaws.mws.MarketplaceWebService;
import com.amazonaws.mws.MarketplaceWebServiceClient;
import com.amazonaws.mws.MarketplaceWebServiceConfig;
import com.amazonservices.mws.orders.model.MarketplaceIdList;

import java.util.Collections;

/**
 * User: Luo
 * Date: 12-6-11
 * Time: 上午12:34
 */
public class AmazonConfig {
    public static final String accessKeyId = "AKIAJDR2N32XSM5HT2ZQ";
    public static final String secretAccessKey = "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";
    public static final String applicationName = "test_app";
    public static final String applicationVersion = "1.0";

    public static final String sellerId = "A1BBJ68YCYJXU7";
    public static MarketplaceIdList marketplaceIdList = new MarketplaceIdList(Collections.singletonList("AAHKV2X7AFYLW"));

    public static String orderServiceUrl = "https://mws.amazonservices.com.cn/Orders/2011-01-01";
    public static String wsServiceUrl = "https://mws.amazonservices.com.cn";

    public static MarketplaceWebService getMarketplaceWebService() {
        MarketplaceWebServiceConfig config = new MarketplaceWebServiceConfig();
        config.setServiceURL(wsServiceUrl);
        MarketplaceWebService service = new MarketplaceWebServiceClient(
                accessKeyId, secretAccessKey, applicationName, applicationVersion, config);
        return service;

    }

}
