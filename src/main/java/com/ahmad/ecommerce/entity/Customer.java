package com.ahmad.ecommerce.entity;

import com.ahmad.ecommerce.entity.enums.UserRole;

public class Customer extends User{
    public Customer(String username, String phoneNumber, String email, String password) {
        super(username, phoneNumber, email, password, UserRole.CUSTOMER);
    }
}
