package com.ahmad.ecommerce.entity;

import com.ahmad.ecommerce.entity.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    User user;
    LocalDateTime orderDate;
    OrderStatus status;
    List<OrderItem> orderItems;
    private BigDecimal totalPrice;

    public Order(User user, LocalDateTime orderDate, OrderStatus status) {
        this.user = user;
        this.orderDate = orderDate;
        this.status = status;
        this.orderItems = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
