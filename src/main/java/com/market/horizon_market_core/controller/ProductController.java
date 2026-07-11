package com.market.horizon_market_core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.market.horizon_market_core.dto.ProductResponseDto;
import com.market.horizon_market_core.repository.InventoryRepository;
import com.market.horizon_market_core.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository, InventoryRepository inventoryRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<ProductResponseDto> findBySku(@PathVariable String sku){

        
        return productRepository.findBySku(sku)
                .map(product -> {
                    ProductResponseDto productResponseDto = new ProductResponseDto();
                    productResponseDto.setName(product.getName());
                    productResponseDto.setDescription(product.getDescription());
                    productResponseDto.setPrice(product.getPrice());
                    productResponseDto.setSku(product.getSku());
                    productResponseDto.setAvailableQuantity(product.getInventory().getAvailableQuantity());
                    return ResponseEntity.ok(productResponseDto);
                    }
                ).orElse(ResponseEntity.notFound().build());
    }
    
}
