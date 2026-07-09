package com.market.horizon_market_core.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="inventory", indexes = {@Index(name="inventory_product_id_index", columnList = "product_id")})
@NoArgsConstructor
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private int availableQuantity;

    @Column(nullable=false)
    private int reservedQuantity;

    @Column(name="created_at", updatable=false)
    private LocalDateTime createdAt;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false, unique=true)
    private Product product;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
