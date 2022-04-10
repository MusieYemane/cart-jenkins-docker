package com.mosi.shoppingCart.product.service;

import com.mosi.shoppingCart.product.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();
    Optional<Product> getProductById(String productId);
    Product addProduct(Product product);
    Product updateProduct(String productId, Product product);
    void deleteProduct(String productId);

}
