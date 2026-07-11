package com.market.horizon_market_core.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {

    private String name;
    private String description;
    private BigDecimal price;
    private String sku;
    private int availableQuantity;
    
}
