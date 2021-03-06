package com.mosi.shoppingCart.product.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document
public class Product {
    @Id
    private String productId;
    @NotNull @NotBlank
    private String productName;
    private double productPrice;
    @NotNull @NotBlank
    private String productDesc;
    private List<String> images;

    public Product(String productName, double productPrice, String productDesc, List<String> images) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.images = images;
    }
}
