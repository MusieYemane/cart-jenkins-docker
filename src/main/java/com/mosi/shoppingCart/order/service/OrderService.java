package com.mosi.shoppingCart.order.service;

import com.mosi.shoppingCart.order.domain.Order;

import java.util.List;

public interface OrderService {

    Order addOrder(Order order);
    Order findByCustomerId(String customerId);
    List<Order> getAllOrdersByCustomer(String customerId);

}
