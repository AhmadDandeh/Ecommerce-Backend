package com.ahmad.ecommerce.entity;

import java.math.BigDecimal;

public class OrderItem {
    private Product product;
    private int quantity;
    private BigDecimal priceAtPurchase;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.priceAtPurchase = product.getPrice();
    }

    public BigDecimal getTotalPrice() {
        return priceAtPurchase.multiply(new BigDecimal(quantity));
    }
}
