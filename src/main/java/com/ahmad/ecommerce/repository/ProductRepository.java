package com.ahmad.ecommerce.repository;

import com.ahmad.ecommerce.entity.Category;
import com.ahmad.ecommerce.entity.Product;
import com.ahmad.ecommerce.entity.Seller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductRepository {
    // In-memory list to act as our temporary database
    private List<Product> products = new ArrayList<>();

    private static ProductRepository instance;

    // Private constructor to initialize dummy data
    private ProductRepository() {
        seedData();
    }

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    // Method to populate the repository with initial test products
    private void seedData() {
        // Creating sample categories
        Category electronics = new Category("Electronics");
        Category appliances = new Category("Appliances");

        Seller seller1 = new Seller("Ahmad", "123", "ahmad@gmail.com", "123");
        Seller seller2 = new Seller("Ali", "456", "ali@gmail.com", "456");

        // Adding products to the list
        // Note: Prices are handled with BigDecimal for financial accuracy
        products.add(new Product("iPhone 15", new BigDecimal("999.99"), 10, electronics, seller1));
        products.add(new Product("Samsung S24", new BigDecimal("899.50"), 10, electronics, seller1));
        products.add(new Product("MacBook Pro", new BigDecimal("1999.00"), 10, electronics, seller2));
        products.add(new Product("AirPods Pro", new BigDecimal("249.00"), 10, electronics, seller1));
        products.add(new Product("Coffee Maker", new BigDecimal("75.25"), 10, appliances, seller2));

        // Console log for debugging
        System.out.println("System Message: ProductRepository initialized with " + products.size() + " products.");
    }

    // Adds a new product to the inventory
    public void save(Product product) {
        this.products.add(product);
    }

    // Returns a copy of the product list to maintain encapsulation
    public List<Product> findAll() {
        return new ArrayList<>(this.products);
    }

    // Searches for a product by its name (case-insensitive)
    public Optional<Product> findByName(String name) {
        return this.products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    // Filters products based on their category name
    public List<Product> findByCategory(String categoryName) {
        return this.products.stream()
                .filter(p -> p.getCategory().getName().equalsIgnoreCase(categoryName))
                .collect(Collectors.toList());
    }

    // Removes a product from the list by name
    public boolean delete(String name) {
        return this.products.removeIf(p -> p.getName().equalsIgnoreCase(name));
    }
}