package com.ahmad.ecommerce.repository;

import com.ahmad.ecommerce.entity.Customer;
import com.ahmad.ecommerce.entity.Order;
import com.ahmad.ecommerce.entity.User;
import com.ahmad.ecommerce.entity.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    private static OrderRepository instance;

    private OrderRepository(){
        seedData();
    }

    public static OrderRepository getInstance(){
        if(instance == null){
            instance = new OrderRepository();
        }
        return instance;
    }


    // Method to populate the repository with initial test users
    private void seedData() {
        Customer customer1 = new Customer("Adam", "222", "adam@gmail.com", "222");
        Customer customer2 = new Customer("Sara", "333", "sara@gmail.com", "333");

        Order order1 = new Order(customer1, LocalDateTime.of(2025, 7, 20, 15, 37), OrderStatus.DELIVERED);
        order1.setTotalPrice(BigDecimal.valueOf(200));
        Order order2 = new Order(customer1, LocalDateTime.of(2025, 10, 14, 7, 52), OrderStatus.CANCELLED);
        order2.setTotalPrice(BigDecimal.valueOf(400));
        Order order3 = new Order(customer1, LocalDateTime.of(2026, 4, 12, 10, 40), OrderStatus.PROCESSING);
        order3.setTotalPrice(BigDecimal.valueOf(300));
        Order order4 = new Order(customer2, LocalDateTime.of(2025, 9, 21, 20, 12), OrderStatus.DELIVERED);
        order4.setTotalPrice(BigDecimal.valueOf(600));
        Order order5 = new Order(customer2, LocalDateTime.of(2026, 3, 30, 1, 32), OrderStatus.SHIPPED);
        order5.setTotalPrice(BigDecimal.valueOf(100));
        // Adding products to the list
        // Note: Prices are handled with BigDecimal for financial accuracy
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);


        // Console log for debugging
        System.out.println("System Message: OrderRepository initialized with " + orders.size() + " orders.");
    }

    public void save(Order order){
        orders.add(order);
    }

    public List<Order> findAll(){
        return new ArrayList<>(orders);
    }

    public List<Order> findByUser(User user){
        return orders.stream()
                .filter(o -> o.getUser().getEmail().equalsIgnoreCase(user.getEmail()))
                .toList();
    }
}
