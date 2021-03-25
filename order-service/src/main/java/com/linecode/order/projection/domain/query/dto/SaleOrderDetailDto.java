package com.linecode.order.projection.domain.query.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleOrderDetailDto {
 
    private String id;
    private String buyerName;
    private String status;
    private String createdAt;
    private List<SaleOrderPackageDetailDto> packages;
    
}
