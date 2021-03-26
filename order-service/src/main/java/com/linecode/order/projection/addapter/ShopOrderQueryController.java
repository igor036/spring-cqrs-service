package com.linecode.order.projection.addapter;

import com.linecode.order.projection.domain.query.GetSaleOrderDetailQuery;
import com.linecode.order.projection.domain.query.dto.SaleOrderDetailDto;
import com.linecode.order.projection.domain.service.QueryGateway;
import com.linecode.order.shared.exception.OrderException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class ShopOrderQueryController {
    
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("{id}")
    public ResponseEntity<?> getSaleOrderDetail(@PathVariable String id) {
        try {
            var getSaleOrderDetailQuery = new GetSaleOrderDetailQuery(id);
            var saleOrderDetail = queryGateway.<SaleOrderDetailDto>resolve(getSaleOrderDetailQuery);
            return ResponseEntity.status(HttpStatus.FOUND).body(saleOrderDetail);
        } catch(OrderException ex) {
            return ResponseEntity.status(ex.getHttpStatus()).body(ex.getMessage());
        }
    }
}
