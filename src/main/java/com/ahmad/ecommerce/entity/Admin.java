package com.ahmad.ecommerce.entity;

import com.ahmad.ecommerce.entity.enums.UserRole;

public class Admin extends User{
    public Admin(String username, String phoneNumber, String email, String password) {
        super(username, phoneNumber, email, password, UserRole.ADMIN);
    }
}
