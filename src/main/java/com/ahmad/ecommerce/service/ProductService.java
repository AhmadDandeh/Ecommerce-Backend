package com.ahmad.ecommerce.service;

import com.ahmad.ecommerce.entity.Product;
import com.ahmad.ecommerce.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    ProductRepository  productRepository = ProductRepository.getInstance();

    public List<Product> listAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> searchProducts(String query){
        return productRepository.findAll().stream()
                .filter(p -> p.getName().equalsIgnoreCase(query) || p.getCategory().getName().equalsIgnoreCase(query))
                .toList();
    }

    public boolean checkStock(Product product, int quantity){
        return productRepository.findByName(product.getName())
                .map(p -> p.getStockQuantity() >= quantity)
                .orElse(false);
    }
    /*
    listAllProducts(): Gets all products for the UI.

searchProducts(String query): Filters products by name or category.

checkStock(Product product, int requestedQty): (Future logic) ensures we have enough items.
     */
}
