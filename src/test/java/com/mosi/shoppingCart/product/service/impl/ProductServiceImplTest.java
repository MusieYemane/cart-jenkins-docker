package com.mosi.shoppingCart.product.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mosi.shoppingCart.product.domain.Product;
import com.mosi.shoppingCart.product.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {
    @MockBean
    private ProductRepo productRepo;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Test
    void testGetAllProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        when(this.productRepo.findAll()).thenReturn(productList);
        List<Product> actualAllProducts = this.productServiceImpl.getAllProducts();
        assertSame(productList, actualAllProducts);
        assertTrue(actualAllProducts.isEmpty());
        verify(this.productRepo).findAll();
    }

    @Test
    void testGetProductById() {
        Product product = new Product();
        product.setImages(new ArrayList<>());
        product.setProductDesc("Product Desc");
        product.setProductId("42");
        product.setProductName("Product Name");
        product.setProductPrice(10.0d);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepo.findById((String) any())).thenReturn(ofResult);
        Optional<Product> actualProductById = this.productServiceImpl.getProductById("42");
        assertSame(ofResult, actualProductById);
        assertTrue(actualProductById.isPresent());
        verify(this.productRepo).findById((String) any());
    }

    @Test
    void testAddProduct() {
        Product product = new Product();
        product.setImages(new ArrayList<>());
        product.setProductDesc("Product Desc");
        product.setProductId("42");
        product.setProductName("Product Name");
        product.setProductPrice(10.0d);
        when(this.productRepo.save((Product) any())).thenReturn(product);

        Product product1 = new Product();
        product1.setImages(new ArrayList<>());
        product1.setProductDesc("Product Desc");
        product1.setProductId("42");
        product1.setProductName("Product Name");
        product1.setProductPrice(10.0d);
        assertSame(product, this.productServiceImpl.addProduct(product1));
        verify(this.productRepo).save((Product) any());
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        product.setImages(new ArrayList<>());
        product.setProductDesc("Product Desc");
        product.setProductId("42");
        product.setProductName("Product Name");
        product.setProductPrice(10.0d);
        when(this.productRepo.save((Product) any())).thenReturn(product);

        Product product1 = new Product();
        product1.setImages(new ArrayList<>());
        product1.setProductDesc("Product Desc");
        product1.setProductId("42");
        product1.setProductName("Product Name");
        product1.setProductPrice(10.0d);
        assertSame(product, this.productServiceImpl.updateProduct("42", product1));
        verify(this.productRepo).save((Product) any());
    }
}

