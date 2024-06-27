package com.example.Bai1.RequestRespone;

import org.springframework.http.HttpStatus;

public class PurchaseResponse {
    private HttpStatus statusCode;
    private String message;

    public PurchaseResponse() {

    }

    public PurchaseResponse(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
