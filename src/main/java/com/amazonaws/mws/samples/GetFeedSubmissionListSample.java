/******************************************************************************* 
 *  Copyright 2009 Amazon Services.
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *
 *  You may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 *  CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 *  specific language governing permissions and limitations under the License.
 * ***************************************************************************** 
 *
 *  Marketplace Web Service Java Library
 *  API Version: 2009-01-01
 *  Generated: Wed Feb 18 13:28:48 PST 2009 
 *
 */


package com.amazonaws.mws.samples;

import java.util.List;
import java.util.ArrayList;

import amazclient.AmazonConfig;
import com.amazonaws.mws.*;
import com.amazonaws.mws.model.*;
import com.amazonaws.mws.mock.MarketplaceWebServiceMock;

/**
 * Get Feed Submission List  Samples
 */
public class GetFeedSubmissionListSample {

    /**
     * Just add a few required parameters, and try the service
     * Get Feed Submission List functionality
     *
     * @param args unused
     */
    public static void main(String... args) {


        MarketplaceWebService service = AmazonConfig.getMarketplaceWebService();

        GetFeedSubmissionListRequest request = new GetFeedSubmissionListRequest();
        request.setMerchant(AmazonConfig.sellerId);

        invokeGetFeedSubmissionList(service, request);

    }


    /**
     * Get Feed Submission List  request sample
     * returns a list of feed submission identifiers and their associated metadata
     *
     * @param service instance of MarketplaceWebService service
     * @param request Action to invoke
     */
    public static void invokeGetFeedSubmissionList(MarketplaceWebService service, GetFeedSubmissionListRequest request) {
        try {

            GetFeedSubmissionListResponse response = service.getFeedSubmissionList(request);


            System.out.println("GetFeedSubmissionList Action Response");
            System.out.println("=============================================================================");
            System.out.println();

            System.out.print("    GetFeedSubmissionListResponse");
            System.out.println();
            if (response.isSetGetFeedSubmissionListResult()) {
                System.out.print("        GetFeedSubmissionListResult");
                System.out.println();
                GetFeedSubmissionListResult getFeedSubmissionListResult = response.getGetFeedSubmissionListResult();
                if (getFeedSubmissionListResult.isSetNextToken()) {
                    System.out.print("            NextToken");
                    System.out.println();
                    System.out.print("                " + getFeedSubmissionListResult.getNextToken());
                    System.out.println();
                }
                if (getFeedSubmissionListResult.isSetHasNext()) {
                    System.out.print("            HasNext");
                    System.out.println();
                    System.out.print("                " + getFeedSubmissionListResult.isHasNext());
                    System.out.println();
                }
                java.util.List<FeedSubmissionInfo> feedSubmissionInfoList = getFeedSubmissionListResult.getFeedSubmissionInfoList();
                for (FeedSubmissionInfo feedSubmissionInfo : feedSubmissionInfoList) {
                    System.out.print("            FeedSubmissionInfo");
                    System.out.println();
                    if (feedSubmissionInfo.isSetFeedSubmissionId()) {
                        System.out.print("                FeedSubmissionId");
                        System.out.println();
                        System.out.print("                    " + feedSubmissionInfo.getFeedSubmissionId());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetFeedType()) {
                        System.out.print("                FeedType");
                        System.out.println();
                        System.out.print("                    " + feedSubmissionInfo.getFeedType());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetSubmittedDate()) {
                        System.out.print("                SubmittedDate");
                        System.out.println();
                        System.out.print("                    " + feedSubmissionInfo.getSubmittedDate());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetFeedProcessingStatus()) {
                        System.out.print("                FeedProcessingStatus");
                        System.out.println();
                        System.out.print("                    " + feedSubmissionInfo.getFeedProcessingStatus());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetStartedProcessingDate()) {
                        System.out.print("                StartedProcessingDate");
                        System.out.println();
                        System.out.print("                    " + feedSubmissionInfo.getStartedProcessingDate());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetCompletedProcessingDate()) {
                        System.out.print("                CompletedProcessingDate");
                        System.out.println();
                        System.out.print("                    " + feedSubmissionInfo.getCompletedProcessingDate());
                        System.out.println();
                    }
                }
            }
            if (response.isSetResponseMetadata()) {
                System.out.print("        ResponseMetadata");
                System.out.println();
                ResponseMetadata responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.print("            RequestId");
                    System.out.println();
                    System.out.print("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println(response.getResponseHeaderMetadata());
            System.out.println();


        } catch (MarketplaceWebServiceException ex) {

            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
            System.out.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
        }
    }

}
