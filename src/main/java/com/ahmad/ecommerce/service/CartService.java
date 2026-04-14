package com.ahmad.ecommerce.service;

import com.ahmad.ecommerce.entity.Cart;
import com.ahmad.ecommerce.entity.CartItem;
import com.ahmad.ecommerce.entity.Product;
import java.math.BigDecimal;

public class CartService {

    // We hold a reference to the current user's cart
    private Cart cart;
    private ProductService productService;

    public CartService(ProductService productService) {
        this.cart = new Cart();
        this.productService = productService;
    }

    /**
     * Adds a product to the cart.
     * If the product already exists, it increases the quantity.
     */
    public void addToCart(Product product, int quantity) {
        // 1. Check stock availability before doing anything
        if (!productService.checkStock(product, quantity)) {
            System.out.println("Error: Not enough stock for " + product.getName());
            return; // Stop the execution
        }

        // 2. If stock is available, proceed with the existing logic
        cart.getItems().stream()
                .filter(item -> item.getProduct().equals(product))
                .findFirst()
                .ifPresentOrElse(
                        item -> item.setQuantity(item.getQuantity() + quantity),
                        () -> cart.addItem(new CartItem(product, quantity))
                );

        System.out.println("Success: Added " + quantity + " of " + product.getName() + " to cart.");
    }

    /**
     * Updates the quantity of a product in the cart.
     * If quantity reaches 0, the product is removed.
     */
    public void updateQuantity(Product product, int newQuantity) {
        if(newQuantity <= 0) removeFromCart(product);
        else{
            cart.getItems().stream()
                    .filter(item -> item.getProduct().getName().equalsIgnoreCase(product.getName()))
                    .findFirst()
                    .ifPresent(item -> item.setQuantity(newQuantity));
        }
    }

    /**
     * Removes a product completely from the cart.
     */
    public void removeFromCart(Product product) {
        cart.getItems().removeIf(item -> item.getProduct().equals(product));
    }

    /**
     * Calculates the total price of all items in the cart.
     */
    public BigDecimal getCartTotal() {
        return cart.getTotal();
    }

    public void clearCart() {
        cart.getItems().clear();
    }

    public Cart getCart() {
        return cart;
    }
}
