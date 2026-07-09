package com.market.horizon_market_core.repository;

import com.market.horizon_market_core.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySku(String sku);
    
    
}
