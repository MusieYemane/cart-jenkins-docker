package com.mosi.shoppingCart.order.domain;

import com.mosi.shoppingCart.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    private List<Order> orders;
}
