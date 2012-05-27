/******************************************************************************* 
 *  Copyright 2008-2009 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  
 *  You may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 *  CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 *  specific language governing permissions and limitations under the License.
 * ***************************************************************************** 
 *    __  _    _  ___ 
 *   (  )( \/\/ )/ __)
 *   /__\ \    / \__ \
 *  (_)(_) \/\/  (___/
 * 
 *  Marketplace Web Service Orders Java Library
 *  API Version: 2011-01-01
 *  Generated: Wed Jan 26 00:20:38 UTC 2011 
 * 
 */

package com.amazonservices.mws.orders.samples;


import com.amazonservices.mws.orders.MarketplaceWebServiceOrders;
import com.amazonservices.mws.orders.MarketplaceWebServiceOrdersClient;
import com.amazonservices.mws.orders.MarketplaceWebServiceOrdersException;
import com.amazonservices.mws.orders.model.Address;
import com.amazonservices.mws.orders.model.ListOrdersRequest;
import com.amazonservices.mws.orders.model.ListOrdersResponse;
import com.amazonservices.mws.orders.model.ListOrdersResult;
import com.amazonservices.mws.orders.model.Money;
import com.amazonservices.mws.orders.model.Order;
import com.amazonservices.mws.orders.model.OrderList;
import com.amazonservices.mws.orders.model.PaymentExecutionDetailItem;
import com.amazonservices.mws.orders.model.PaymentExecutionDetailItemList;
import com.amazonservices.mws.orders.model.ResponseMetadata;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

/**
 * 
 * List Orders Samples
 * 
 * 
 */
public class ListOrdersSample {

    /**
     * Just add few required parameters, and try the service List Orders
     * functionality
     * 
     * @param args
     *            unused
     */
    public static void main(String... args) {

        /*
         * Add required parameters in OrdersSampleConfig.java before trying out
         * this sample.
         */

        /************************************************************************
         * Instantiate Http Client Implementation of Marketplace Web Service
         * Orders
         ***********************************************************************/
        MarketplaceWebServiceOrders service = new MarketplaceWebServiceOrdersClient(
                OrdersSampleConfig.accessKeyId,
                OrdersSampleConfig.secretAccessKey,
                OrdersSampleConfig.applicationName,
                OrdersSampleConfig.applicationVersion,
                OrdersSampleConfig.config);

        /************************************************************************
         * Uncomment to try out Mock Service that simulates Marketplace Web
         * Service Orders responses without calling Marketplace Web Service
         * Orders service.
         * 
         * Responses are loaded from local XML files. You can tweak XML files to
         * experiment with various outputs during development
         * 
         * XML files available under com/amazonservices/mws/mock tree
         * 
         ***********************************************************************/
        // MarketplaceWebServiceOrders service = new
        // MarketplaceWebServiceOrdersMock();

        /************************************************************************
         * Setup request parameters and uncomment invoke to try out sample for
         * List Orders
         ***********************************************************************/
        ListOrdersRequest request = new ListOrdersRequest();

        // @TODO: set request parameters here
        request.setSellerId(OrdersSampleConfig.sellerId);
        request.setMarketplaceId(OrdersSampleConfig.marketplaceIdList);
        XMLGregorianCalendarImpl xmlGregorianCalendar = new XMLGregorianCalendarImpl();
        xmlGregorianCalendar.setYear(2000);
        request.setCreatedAfter(xmlGregorianCalendar);

        /*
         * Setting a start date of January 01, 2011 GMT. TODO: Customize
         * according to your requirements.
         */

        invokeListOrders(service, request);

    }

    /**
     * List Orders request sample ListOrders can be used to find orders that
     * meet the specified criteria.
     * 
     * @param service
     *            instance of MarketplaceWebServiceOrders service
     * @param request
     *            Action to invoke
     */
    public static void invokeListOrders(MarketplaceWebServiceOrders service,
            ListOrdersRequest request) {
        try {

            ListOrdersResponse response = service.listOrders(request);

            System.out.println("ListOrders Action Response");
            System.out
                    .println("=============================================================================");
            System.out.println();

            System.out.println("    ListOrdersResponse");
            System.out.println();
            if (response.isSetListOrdersResult()) {
                System.out.println("        ListOrdersResult");
                System.out.println();
                ListOrdersResult listOrdersResult = response
                        .getListOrdersResult();
                if (listOrdersResult.isSetNextToken()) {
                    System.out.println("            NextToken");
                    System.out.println();
                    System.out.println("                "
                            + listOrdersResult.getNextToken());
                    System.out.println();
                }
                if (listOrdersResult.isSetCreatedBefore()) {
                    System.out.println("            CreatedBefore");
                    System.out.println();
                    System.out.println("                "
                            + listOrdersResult.getCreatedBefore());
                    System.out.println();
                }
                if (listOrdersResult.isSetLastUpdatedBefore()) {
                    System.out.println("            LastUpdatedBefore");
                    System.out.println();
                    System.out.println("                "
                            + listOrdersResult.getLastUpdatedBefore());
                    System.out.println();
                }
                if (listOrdersResult.isSetOrders()) {
                    System.out.println("            Orders");
                    System.out.println();
                    OrderList orders = listOrdersResult.getOrders();
                    java.util.List<Order> orderList = orders.getOrder();
                    for (Order order : orderList) {
                        System.out.println("                Order");
                        System.out.println();
                        if (order.isSetAmazonOrderId()) {
                            System.out
                                    .println("                    AmazonOrderId");
                            System.out.println();
                            System.out.println("                        "
                                    + order.getAmazonOrderId());
                            System.out.println();
                        }
                        if (order.isSetSellerOrderId()) {
                            System.out
                                    .println("                    SellerOrderId");
                            System.out.println();
                            System.out.println("                        "
                                    + order.getSellerOrderId());
                            System.out.println();
                        }
                        if (order.isSetPurchaseDate()) {
                            System.out
                                    .println("                    PurchaseDate");
                            System.out.println();
                            System.out.println("                        "
                                    + order.getPurchaseDate());
                            System.out.println();
                        }
                        if (order.isSetLastUpdateDate()) {
                            System.out
                                    .println("                    LastUpdateDate");
                            System.out.println();
                            System.out.println("                        "
                                    + order.getLastUpdateDate());
                            System.out.println();
                        }
                        if (order.isSetOrderStatus()) {
                            System.out
                                    .println("                    OrderStatus");
                            System.out.println();
                            System.out.println("                        "
                                    + order.getOrderStatus().value());
                            System.out.println();
                        }
                        if (order.isSetFulfillmentChannel()) {
                            System.out
                                    .println("                    FulfillmentChannel");
                            System.out.println();
                            System.out.println("                        "
                                    + order.getFulfillmentChannel().value());
                            System.out.println();
                        }
                        if (order.isSetSalesChannel()) {
                            System.out
                                    .println("                    SalesChannel");
                            System.out.println();
                            System.out.println("                        "
                                    + order.getSalesChannel());
                            System.out.println();
                        }
                        if (order.isSetOrderChannel()) {
                            System.out
                                    .println("                    OrderChannel");
                            System.out.println();
                            System.out.println("                        "
                                    + order.getOrderChannel());
                            System.out.println();
                        }
                        if (order.isSetShipServiceLevel()) {
                            System.out
                                    .println("                    ShipServiceLevel");
                            System.out.println();
                            System.out.println("                        "
                                    + order.getShipServiceLevel());
                            System.out.println();
                        }
                        if (order.isSetShippingAddress()) {
                            System.out
                                    .println("                    ShippingAddress");
                            System.out.println();
                            Address shippingAddress = order
                                    .getShippingAddress();
                            if (shippingAddress.isSetName()) {
                                System.out
                                        .println("                        Name");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + shippingAddress.getName());
                                System.out.println();
                            }
                            if (shippingAddress.isSetAddressLine1()) {
                                System.out
                                        .println("                        AddressLine1");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + shippingAddress
                                                        .getAddressLine1());
                                System.out.println();
                            }
                            if (shippingAddress.isSetAddressLine2()) {
                                System.out
                                        .println("                        AddressLine2");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + shippingAddress
                                                        .getAddressLine2());
                                System.out.println();
                            }
                            if (shippingAddress.isSetAddressLine3()) {
                                System.out
                                        .println("                        AddressLine3");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + shippingAddress
                                                        .getAddressLine3());
                                System.out.println();
                            }
                            if (shippingAddress.isSetCity()) {
                                System.out
                                        .println("                        City");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + shippingAddress.getCity());
                                System.out.println();
                            }
                            if (shippingAddress.isSetCounty()) {
                                System.out
                                        .println("                        County");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + shippingAddress.getCounty());
                                System.out.println();
                            }
                            if (shippingAddress.isSetDistrict()) {
                                System.out
                                        .println("                        District");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + shippingAddress.getDistrict());
                                System.out.println();
                            }
                            if (shippingAddress.isSetStateOrRegion()) {
                                System.out
                                        .println("                        StateOrRegion");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + shippingAddress
                                                        .getStateOrRegion());
                                System.out.println();
                            }
                            if (shippingAddress.isSetPostalCode()) {
                                System.out
                                        .println("                        PostalCode");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + shippingAddress
                                                        .getPostalCode());
                                System.out.println();
                            }
                            if (shippingAddress.isSetCountryCode()) {
                                System.out
                                        .println("                        CountryCode");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + shippingAddress
                                                        .getCountryCode());
                                System.out.println();
                            }
                            if (shippingAddress.isSetPhone()) {
                                System.out
                                        .println("                        Phone");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + shippingAddress.getPhone());
                                System.out.println();
                            }
                        }
                        if (order.isSetOrderTotal()) {
                            System.out
                                    .println("                    OrderTotal");
                            System.out.println();
                            Money orderTotal = order.getOrderTotal();
                            if (orderTotal.isSetCurrencyCode()) {
                                System.out
                                        .println("                        CurrencyCode");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + orderTotal.getCurrencyCode());
                                System.out.println();
                            }
                            if (orderTotal.isSetAmount()) {
                                System.out
                                        .println("                        Amount");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + orderTotal.getAmount());
                                System.out.println();
                            }
                        }
                        if (order.isSetNumberOfItemsShipped()) {
                            System.out
                                    .println("                    NumberOfItemsShipped");
                            System.out.println();
                            System.out.println("                        "
                                    + order.getNumberOfItemsShipped());
                            System.out.println();
                        }
                        if (order.isSetNumberOfItemsUnshipped()) {
                            System.out
                                    .println("                    NumberOfItemsUnshipped");
                            System.out.println();
                            System.out.println("                        "
                                    + order.getNumberOfItemsUnshipped());
                            System.out.println();
                        }
                        if (order.isSetPaymentExecutionDetail()) {
                            System.out.println("                    PaymentExecutionDetail");
                            System.out.println();
                            PaymentExecutionDetailItemList  paymentExecutionDetail = order.getPaymentExecutionDetail();
                            java.util.List<PaymentExecutionDetailItem> paymentExecutionDetailItemList = paymentExecutionDetail.getPaymentExecutionDetailItem();
                            for (PaymentExecutionDetailItem paymentExecutionDetailItem : paymentExecutionDetailItemList) {
                                System.out.println("                        PaymentExecutionDetailItem");
                                System.out.println();
                                if (paymentExecutionDetailItem.isSetPayment()) {
                                    System.out.println("                            Payment");
                                    System.out.println();
                                    Money  payment = paymentExecutionDetailItem.getPayment();
                                    if (payment.isSetCurrencyCode()) {
                                        System.out.println("                                CurrencyCode");
                                        System.out.println();
                                        System.out.println("                                    " + payment.getCurrencyCode());
                                        System.out.println();
                                    }
                                    if (payment.isSetAmount()) {
                                        System.out.println("                                Amount");
                                        System.out.println();
                                        System.out.println("                                    " + payment.getAmount());
                                        System.out.println();
                                    }
                                } 
                                if (paymentExecutionDetailItem.isSetSubPaymentMethod()) {
                                    System.out.println("                            SubPaymentMethod");
                                    System.out.println();
                                    System.out.println("                                " + paymentExecutionDetailItem.getSubPaymentMethod());
                                    System.out.println();
                                }
                            }
                        } 
                        if (order.isSetPaymentMethod()) {
                            System.out.println("                    PaymentMethod");
                            System.out.println();
                            System.out.println("                        " + order.getPaymentMethod().value());
                            System.out.println();
                        }
                        if (order.isSetMarketplaceId()) {
                            System.out.println("                    MarketplaceId");
                            System.out.println();
                            System.out.println("                        " + order.getMarketplaceId());
                            System.out.println();
                        }
                        if (order.isSetBuyerEmail()) {
                            System.out.println("                    BuyerEmail");
                            System.out.println();
                            System.out.println("                        " + order.getBuyerEmail());
                            System.out.println();
                        }
                        if (order.isSetBuyerName()) {
                            System.out.println("                    BuyerName");
                            System.out.println();
                            System.out.println("                        " + order.getBuyerName());
                            System.out.println();
                        }
                        if (order.isSetShipmentServiceLevelCategory()) {
                            System.out.println("                    ShipmentServiceLevelCategory");
                            System.out.println();
                            System.out.println("                        " + order.getShipmentServiceLevelCategory());
                            System.out.println();
                        }
                    }
                }
            }
            if (response.isSetResponseMetadata()) {
                System.out.println("        ResponseMetadata");
                System.out.println();
                ResponseMetadata responseMetadata = response
                        .getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.println("            RequestId");
                    System.out.println();
                    System.out.println("                "
                            + responseMetadata.getRequestId());
                    System.out.println();
                }
            }
            System.out.println();

        } catch (MarketplaceWebServiceOrdersException ex) {

            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
        }
    }

}
