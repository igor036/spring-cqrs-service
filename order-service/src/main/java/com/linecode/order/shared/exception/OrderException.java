package com.linecode.order.shared.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public abstract class OrderException extends RuntimeException {
    
    private String message;
    private HttpStatus httpStatus;

    public OrderException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
