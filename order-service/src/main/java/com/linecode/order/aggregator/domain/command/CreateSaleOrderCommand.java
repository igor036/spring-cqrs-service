package com.linecode.order.aggregator.domain.command;

import java.util.List;
import java.util.UUID;

import com.linecode.order.aggregator.domain.command.dto.CreateSaleOrderPackageDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateSaleOrderCommand implements Command {
    
    private final String id = UUID.randomUUID().toString();
    private String buyerName;
    private List<CreateSaleOrderPackageDto> packages;
    
}
