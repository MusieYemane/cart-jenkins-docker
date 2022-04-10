package com.mosi.shoppingCart.order.repository;


import com.mosi.shoppingCart.order.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{
    List<Order> findByCustomerId(String customerId);

    @Query("{customerId :?0}")                                                  //SQL Equivalent : SELECT * FROM ORDERS WHERE customerId=?
    List<Order> getAllOrdersByCustomer(String customerId);
}
