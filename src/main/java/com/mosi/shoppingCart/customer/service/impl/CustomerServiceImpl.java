package com.mosi.shoppingCart.customer.service.impl;

import com.mosi.shoppingCart.customer.domain.Customer;
import com.mosi.shoppingCart.customer.repository.CustomerRepo;
import com.mosi.shoppingCart.customer.service.CustomerService;
import com.mosi.shoppingCart.product.domain.Product;
import com.mosi.shoppingCart.product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(String customerId) {
        return customerRepo.findById(customerId);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(String customerId, Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepo.delete(customer);
    }

    @Override
    public Optional<Customer> findByUsernameAndAndPassword(String username, String password) {
        return customerRepo.findByUsernameAndAndPassword(username, password);
    }


}
