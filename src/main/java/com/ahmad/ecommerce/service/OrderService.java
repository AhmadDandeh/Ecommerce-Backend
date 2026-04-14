package com.ahmad.ecommerce.service;

import com.ahmad.ecommerce.entity.CartItem;
import com.ahmad.ecommerce.entity.Order;
import com.ahmad.ecommerce.entity.Product;
import com.ahmad.ecommerce.entity.User;
import com.ahmad.ecommerce.entity.enums.OrderStatus;
import com.ahmad.ecommerce.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;

    // Injecting dependencies through the constructor
    public OrderService(OrderRepository orderRepository, CartService cartService) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
    }

    public void checkOut(User user) {
        List<CartItem> cartItems = cartService.getCart().getItems();
        // 1. Check if the cart is empty before processing
        if (cartItems.isEmpty()) {
            System.out.println("Error: Cannot checkout an empty cart.");
            return;
        }

        for (CartItem item : cartItems) {
            Product product = item.getProduct();
            int quantitySold = item.getQuantity();

            int newStock = product.getStockQuantity() - quantitySold;
            product.setStockQuantity(newStock);
        }

        // 2. Create the order with current timestamp and initial status
        Order order = new Order(user, LocalDateTime.now(), OrderStatus.PROCESSING);

        // 3. Set the total price (The Snapshot)
        order.setTotalPrice(cartService.getCartTotal());

        // 4. Save to repository
        orderRepository.save(order);

        // 5. Clear the cart after successful order placement
        cartService.clearCart();

        System.out.println("Success: Order placed for " + user.getUsername());
    }

    public List<Order> getUserOrders(User user){
        return orderRepository.findByUser(user);
    }
}
