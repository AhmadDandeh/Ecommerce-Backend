package com.ahmad.ecommerce;


import com.ahmad.ecommerce.entity.*;
import com.ahmad.ecommerce.repository.*;
import com.ahmad.ecommerce.service.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize Repositories (Singletons)
        UserRepository userRepo = UserRepository.getInstance();
        ProductRepository productRepo = ProductRepository.getInstance();
        OrderRepository orderRepo = OrderRepository.getInstance();

        // 2. Initialize Services and Inject Dependencies
        UserService userService = new UserService();
        ProductService productService = new ProductService();
        CartService cartService = new CartService(productService);
        OrderService orderService = new OrderService(orderRepo, cartService);

        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        System.out.println("--- Welcome to Ahmad's E-Commerce System ---");

        // Main Application Loop
        while (true) {
            if (currentUser == null) {
                // Menu for Guest Users
                System.out.println("\n1. Register New User");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (choice == 1) {
                    System.out.print("Name: "); String name = scanner.nextLine();
                    System.out.print("Email: "); String email = scanner.nextLine();
                    System.out.print("Password: "); String pass = scanner.nextLine();
                    // Defaulting to Customer for registration
                    userService.register(new Customer(name, "ID_AUTO", email, pass));
                } else if (choice == 2) {
                    System.out.print("Email: "); String email = scanner.nextLine();
                    System.out.print("Password: "); String pass = scanner.nextLine();
                    // Attempt login and handle Optional result
                    currentUser = userService.login(email, pass).orElse(null);
                    if (currentUser == null) {
                        System.out.println("Error: Invalid credentials!");
                    } else {
                        System.out.println("Welcome back, " + currentUser.getUsername() + "!");
                    }
                } else if (choice == 0) break;

            } else {
                // Menu for Authenticated Users
                System.out.println("\n--- Main Menu ---");
                System.out.println("1. List Products");
                System.out.println("2. Add Product to Cart");
                System.out.println("3. View Cart & Checkout");
                System.out.println("4. My Order History");
                System.out.println("5. Logout");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        // Display all products using Stream/Lambda
                        productService.listAllProducts().forEach(p ->
                                System.out.println(p.getName() + " - " + p.getPrice() + " USD (Stock: " + p.getStockQuantity() + ")"));
                        break;
                    case 2:
                        System.out.print("Search for Product (Name or Category): ");
                        String query = scanner.nextLine();

                        // 1. Get the list of results
                        List<Product> results = productService.searchProducts(query);

                        if (results.isEmpty()) {
                            System.out.println("No products found matching your search.");
                        } else {
                            // 2. Display results to the user
                            System.out.println("Found " + results.size() + " items:");
                            for (int i = 0; i < results.size(); i++) {
                                System.out.println((i + 1) + ". " + results.get(i).getName() + " (" + results.get(i).getPrice() + " SAR)");
                            }

                            // 3. Ask which one to add
                            System.out.print("Enter the number of the product to add (0 to cancel): ");
                            int choiceIndex = scanner.nextInt();

                            if (choiceIndex > 0 && choiceIndex <= results.size()) {
                                System.out.print("Enter quantity: ");
                                int qty = scanner.nextInt();

                                Product selectedProduct = results.get(choiceIndex - 1);
                                cartService.addToCart(selectedProduct, qty);
                            }
                        }
                        break;
                    case 3:
                        // Show current total and handle checkout
                        System.out.println("Cart Total: " + cartService.getCartTotal() + " SAR");
                        System.out.print("Place order? (y/n): ");
                        if (scanner.next().equalsIgnoreCase("y")) {
                            orderService.checkOut(currentUser);
                        }
                        break;
                    case 4:
                        // Display user-specific order history
                        orderService.getUserOrders(currentUser).forEach(o ->
                                System.out.println("Order Date: " + o.getOrderDate() + " | Total: " + o.getTotalPrice() + " SAR"));
                        break;
                    case 5:
                        // Clear session and reset state
                        currentUser = null;
                        cartService.clearCart();
                        System.out.println("Logged out successfully.");
                        break;
                }
            }
        }
        System.out.println("Thank you for using our system!");
        scanner.close();
    }
}