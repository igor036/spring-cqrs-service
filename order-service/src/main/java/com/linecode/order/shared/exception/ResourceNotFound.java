package com.linecode.order.shared.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFound extends OrderException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFound() {
        super("Requested resource not found!", HttpStatus.NOT_FOUND);
    }

    public ResourceNotFound(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
