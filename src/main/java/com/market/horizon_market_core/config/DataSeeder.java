package com.market.horizon_market_core.config;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.market.horizon_market_core.entity.Inventory;
import com.market.horizon_market_core.entity.Product;
import com.market.horizon_market_core.entity.Role;
import com.market.horizon_market_core.entity.User;
import com.market.horizon_market_core.repository.InventoryRepository;
import com.market.horizon_market_core.repository.ProductRepository;
import com.market.horizon_market_core.repository.UserRepository;

import jakarta.transaction.Transactional;

@Component
public class DataSeeder implements CommandLineRunner{

    public final UserRepository userRepository;
    public final ProductRepository productRepository;
    public final InventoryRepository inventoryRepository;

    public DataSeeder(UserRepository userRepository, ProductRepository productRepository, InventoryRepository inventoryRepository){
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.inventoryRepository = inventoryRepository;
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception{
        if(userRepository.count() == 0){
            User user = new User();
            user.setEmail("Joe@gmail.com");
            user.setPassword("Joe@123");
            user.setRole(Role.SELLER);

            Product product = new Product();
            product.setName("Horizon Developer Laptop");
            product.setDescription("Laptop with I7 processor");
            product.setSku("HRZ-LP-001");
            product.setPrice(new BigDecimal("85000.00"));

            user.addProduct(product);
            userRepository.saveAndFlush(user);

            Inventory inventory = new Inventory();
            inventory.setAvailableQuantity(50);
            inventory.setReservedQuantity(50);
            inventory.setProduct(product);

            inventoryRepository.saveAndFlush(inventory);

            System.out.println("Saved to DB succesfully");

        }
    }
    
}
