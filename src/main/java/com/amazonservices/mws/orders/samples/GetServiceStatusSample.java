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
import com.amazonservices.mws.orders.model.GetServiceStatusRequest;
import com.amazonservices.mws.orders.model.GetServiceStatusResponse;
import com.amazonservices.mws.orders.model.GetServiceStatusResult;
import com.amazonservices.mws.orders.model.Message;
import com.amazonservices.mws.orders.model.MessageList;
import com.amazonservices.mws.orders.model.ResponseMetadata;

/**
 * 
 * Get Service Status Samples
 * 
 * 
 */
public class GetServiceStatusSample {

    /**
     * Just add few required parameters, and try the service Get Service Status
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
         * Instantiate Http Client Implementation of Marketplace Web Service
         * Orders API
         ************************************************************************/
        MarketplaceWebServiceOrders service = new MarketplaceWebServiceOrdersClient(
                OrdersSampleConfig.accessKeyId,
                OrdersSampleConfig.secretAccessKey,
                OrdersSampleConfig.applicationName,
                OrdersSampleConfig.applicationVersion,
                OrdersSampleConfig.config);

        /************************************************************************
         * Setup request parameters and uncomment invoke to try out sample for
         * Get Service Status
         ***********************************************************************/
        GetServiceStatusRequest request = new GetServiceStatusRequest();
        // @TODO: set request parameters here
        request.setSellerId(OrdersSampleConfig.sellerId);

        invokeGetServiceStatus(service, request);

    }
    
    /**
     * Get Service Status request sample Returns the service status of a
     * particular MWS API section. The operation takes no input. All API
     * sections within the API are required to implement this operation.
     * 
     * @param service
     *            instance of MarketplaceWebServiceOrders service
     * @param request
     *            Action to invoke
     */
    public static void invokeGetServiceStatus(
            MarketplaceWebServiceOrders service, GetServiceStatusRequest request) {
        try {

            GetServiceStatusResponse response = service
                    .getServiceStatus(request);

            System.out.println("GetServiceStatus Action Response");
            System.out
                    .println("=============================================================================");
            System.out.println();

            System.out.println("    GetServiceStatusResponse");
            System.out.println();
            if (response.isSetGetServiceStatusResult()) {
                System.out.println("        GetServiceStatusResult");
                System.out.println();
                GetServiceStatusResult getServiceStatusResult = response
                        .getGetServiceStatusResult();
                if (getServiceStatusResult.isSetStatus()) {
                    System.out.println("            Status");
                    System.out.println();
                    System.out.println("                "
                            + getServiceStatusResult.getStatus().value());
                    System.out.println();
                }
                if (getServiceStatusResult.isSetTimestamp()) {
                    System.out.println("            Timestamp");
                    System.out.println();
                    System.out.println("                "
                            + getServiceStatusResult.getTimestamp());
                    System.out.println();
                }
                if (getServiceStatusResult.isSetMessageId()) {
                    System.out.println("            MessageId");
                    System.out.println();
                    System.out.println("                "
                            + getServiceStatusResult.getMessageId());
                    System.out.println();
                }
                if (getServiceStatusResult.isSetMessages()) {
                    System.out.println("            Messages");
                    System.out.println();
                    MessageList messages = getServiceStatusResult.getMessages();
                    java.util.List<Message> messageList = messages.getMessage();
                    for (Message message : messageList) {
                        System.out.println("                Message");
                        System.out.println();
                        if (message.isSetLocale()) {
                            System.out.println("                    Locale");
                            System.out.println();
                            System.out.println("                        "
                                    + message.getLocale());
                            System.out.println();
                        }
                        if (message.isSetText()) {
                            System.out.println("                    Text");
                            System.out.println();
                            System.out.println("                        "
                                    + message.getText());
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
            ex.printStackTrace();
            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
        }
    }

}
