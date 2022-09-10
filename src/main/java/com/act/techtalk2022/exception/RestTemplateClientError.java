package com.act.techtalk2022.exception;

import org.springframework.http.HttpStatus;

public class RestTemplateClientError extends RuntimeException {
    private final HttpStatus status;

    private final String body;

    public RestTemplateClientError(HttpStatus statusCode, String body) {
        status = statusCode;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public HttpStatus getStatus() {
        return status;
    }


}
