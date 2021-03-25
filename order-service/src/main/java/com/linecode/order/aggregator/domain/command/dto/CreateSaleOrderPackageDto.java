package com.linecode.order.aggregator.domain.command.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateSaleOrderPackageDto {

    private String id = UUID.randomUUID().toString();
    private String productGTIN;
    private int amount;

}
