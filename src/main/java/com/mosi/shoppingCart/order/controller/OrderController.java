package com.mosi.shoppingCart.order.controller;


import com.mosi.shoppingCart.order.repository.OrderRepository;
import com.mosi.shoppingCart.order.domain.Orders;
import com.mosi.shoppingCart.order.domain.Order;
import com.mosi.shoppingCart.order.service.OrderService;
import com.mosi.shoppingCart.order.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.addOrder(order));
    }

    @GetMapping("/{customerId}")
    public Orders getAllOrdersByCustomer(@PathVariable("customerId") String customerId){
        return new Orders(orderService.getAllOrdersByCustomer(customerId));
    }

}
