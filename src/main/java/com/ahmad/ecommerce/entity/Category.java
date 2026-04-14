package com.ahmad.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Product> products;

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}
