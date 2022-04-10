package com.mosi.shoppingCart.order.domain;

import com.mosi.shoppingCart.customer.domain.CartLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Order {

    @Id
    private String orderId;
    private String customerId;
    private String orderStatus;
    private LocalDate dateCreated;
    private List<CartLine> cartLines;
}
