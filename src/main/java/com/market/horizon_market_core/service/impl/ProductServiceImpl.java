package com.market.horizon_market_core.service.impl;

import org.springframework.stereotype.Service;
import com.market.horizon_market_core.dto.ProductResponseDto;
import com.market.horizon_market_core.exception.ResourceNotFoundException;
import com.market.horizon_market_core.repository.ProductRepository;
import com.market.horizon_market_core.service.ProductService;

@Service
@org.springframework.transaction.annotation.Transactional(readOnly=true)
public class ProductServiceImpl implements ProductService{
    
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto getProductBySku(String sku) {
        
        return productRepository.findBySku(sku)
            .map(product -> {
                ProductResponseDto productResponseDto = new ProductResponseDto();
                productResponseDto.setName(product.getName());
                productResponseDto.setDescription(product.getDescription());
                productResponseDto.setPrice(product.getPrice());
                productResponseDto.setSku(product.getSku());
                productResponseDto.setAvailableQuantity(product.getInventory().getAvailableQuantity());
                return productResponseDto;
            }).orElseThrow(() -> new ResourceNotFoundException("Product not found with sku: " + sku));
    }
}
