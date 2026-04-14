package com.ahmad.ecommerce.entity;

import com.ahmad.ecommerce.entity.enums.UserRole;

public class Seller extends User{
    public Seller(String username, String phoneNumber, String email, String password) {
        super(username, phoneNumber, email, password, UserRole.SELLER);
    }
}
