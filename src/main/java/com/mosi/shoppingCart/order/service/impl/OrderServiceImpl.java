package com.mosi.shoppingCart.order.service.impl;

import com.mosi.shoppingCart.order.domain.Order;
import com.mosi.shoppingCart.order.repository.OrderRepository;
import com.mosi.shoppingCart.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findByCustomerId(String customerId) {
        return orderRepository.findById(customerId).get();
    }

    @Override
    public List<Order> getAllOrdersByCustomer(String customerId) {
        return orderRepository.getAllOrdersByCustomer(customerId);
    }

}
