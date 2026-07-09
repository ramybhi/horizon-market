package com.market.horizon_market_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.market.horizon_market_core.entity.Inventory;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

    Optional<Inventory> findByAvailableQuantity(int availableQuantity);
    
}
