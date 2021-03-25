package com.linecode.order.aggregator.addapter.controller;

import com.linecode.order.aggregator.domain.command.CreateSaleOrderCommand;
import com.linecode.order.aggregator.domain.service.CommandGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class ShopOrderAggregatorController {
 
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public ResponseEntity<?> createSaleOrder(@RequestBody CreateSaleOrderCommand command) {
        commandGateway.handler(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
