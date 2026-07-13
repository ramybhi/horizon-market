package com.market.horizon_market_core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.market.horizon_market_core.dto.ProductResponseDto;
import com.market.horizon_market_core.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<ProductResponseDto> findBySku(@PathVariable String sku){
        
        ProductResponseDto productResponseDto = productService.getProductBySku(sku);
        return ResponseEntity.ok(productResponseDto);

    }
    
}
