package com.ahmad.ecommerce.entity;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private int stockQuantity;
    private Category category;
    private Seller seller;

    public Product(String name, BigDecimal price, int stockQuantity, Category category, Seller seller) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
