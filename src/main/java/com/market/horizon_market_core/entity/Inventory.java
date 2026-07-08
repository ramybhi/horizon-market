package com.market.horizon_market_core.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="inventory", indexes = {@Index(name="inventory_product_id_index", columnList = "product_id")})
public class Inventory {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(nullable=false)
    private int availableQuantity;
    @Column(nullable=false)
    private int reservedQuantity;
    @Column(name="created_at", updatable=false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false, updatable=false)
    private Product product;


    public Inventory(long id, int availableQuantity, int reservedQuantity, LocalDateTime createdAt, Product product) {
        this.id = id;
        this.availableQuantity = availableQuantity;
        this.reservedQuantity = reservedQuantity;
        this.createdAt = createdAt;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }

    public void setReservedQuantity(int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product){
        this.product=product;
    }

}
