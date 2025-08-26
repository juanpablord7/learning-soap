package com.miempresa.serviceproduct.client;

import com.miempresa.ws.GetCategoryRequest;
import com.miempresa.ws.GetCategoryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class CategorySoapClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CategorySoapClient.class);

    public GetCategoryResponse getCategory(Long id){
        GetCategoryRequest request = new GetCategoryRequest();

        request.setId(id.intValue());

        log.info("Requesting location for " + id);

        GetCategoryResponse response = (GetCategoryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8081/ws/category",
                        request,
                        new SoapActionCallback("http://miempresa.com/ws"));
        return response;
    }
}