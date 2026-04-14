package com.ahmad.ecommerce.repository;

import com.ahmad.ecommerce.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users =  new ArrayList<>();
    private static UserRepository instance;

    private UserRepository() {
        seedData();
    }

    public static UserRepository getInstance(){
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    // Method to populate the repository with initial test users
    private void seedData() {
        Seller seller1 = new Seller("Ahmad", "123", "ahmad@gmail.com", "123");
        Seller seller2 = new Seller("Ali", "456", "ali@gmail.com", "456");

        // Adding products to the list
        // Note: Prices are handled with BigDecimal for financial accuracy
        users.add(new Admin("Sami", "111", "sami@gmail.com", "111"));
        users.add(seller1);
        users.add(seller2);
        users.add(new Customer("Adam", "222", "adam@gmail.com", "222"));
        users.add(new Customer("Sara", "333", "sara@gmail.com", "333"));

        // Console log for debugging
        System.out.println("System Message: UserRepository initialized with " + users.size() + " users.");
    }

    public void save(User user){
        users.add(user);
    }

    public Optional<User> findByEmail(String email){
        return users.stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
    }

    public List<User> findAll(){
        return new ArrayList<>(users);
    }

    public boolean existsByEmail(String email){
        return users.stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }
}
