package com.ahmad.ecommerce.entity;

import com.ahmad.ecommerce.entity.enums.UserRole;

/**
 *
 */
public abstract class User {
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private UserRole role;

    public User(String username, String phoneNumber, String email, String password, UserRole role) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
