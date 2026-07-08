package com.market.horizon_market_core.entity;

import jakarta.persistence.*;
import java.util.*;

import java.time.LocalDateTime;

@Entity
@Table(name="users", indexes = {@Index(name = "idex_user_email", columnList = "email")})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true)
    private String email;
    @Column(nullable=false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Role role;
    @Column(name="created_at", updatable=false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Product> productList;

    public User(long id, String email, String password, Role role, List<Product> productList) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.productList = productList;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Product> getProduct() {
        return productList;
    }

    public void setProduct(List<Product> productList) {
        this.productList = productList;
    }
    
}
