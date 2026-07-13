package com.market.horizon_market_core.service;

import com.market.horizon_market_core.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProductBySku(String sku);
    
}
