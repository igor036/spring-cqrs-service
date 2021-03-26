package com.linecode.order.shared.enumerator;

import lombok.Getter;

@Getter
public enum OrderStatus {
    
    CREATED("created"),
    SHIPPED("shipped"),
    TRAFFIC("traffic"),
    DELIVERED("delivered");

    private String status;

    private OrderStatus(String status) {
        this.status = status;
    }
}
