package com.act.techtalk2022.client;


import com.act.techtalk2022.exception.RestTemplateClientError;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class RestTemplateErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return HttpStatus.OK != clientHttpResponse.getStatusCode();
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        throw new RestTemplateClientError(clientHttpResponse.getStatusCode(), clientHttpResponse.getBody().toString());
    }
}
