package com.market.horizon_market_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.market.horizon_market_core.entity.Inventory;
import com.market.horizon_market_core.entity.Product;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

    Inventory findByProduct(Product product);
    
}
