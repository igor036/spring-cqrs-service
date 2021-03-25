package com.linecode.order.projection.domain.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetSaleOrderDetailQuery implements Query {

    private String saleOrderId;

}
