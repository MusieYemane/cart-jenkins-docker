package com.mosi.shoppingCart.customer.service;

import com.mosi.shoppingCart.customer.domain.Customer;
import com.mosi.shoppingCart.product.domain.Product;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(String customerId);
    Customer addCustomer(Customer customer);
    Customer updateCustomer(String customerId, Customer customer);
    void deleteCustomer(Customer customer);
    Optional<Customer> findByUsernameAndAndPassword(String username, String password);

}
