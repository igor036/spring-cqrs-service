package com.linecode.order.projection.domain.query.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleOrderPackageDetailDto {
    
    private String id;
    private String productGTIN;
    private int amount;
    private String status;
    private String createdAt;
}
