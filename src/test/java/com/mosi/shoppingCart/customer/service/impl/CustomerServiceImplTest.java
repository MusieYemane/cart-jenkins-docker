package com.mosi.shoppingCart.customer.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mosi.shoppingCart.customer.domain.Cart;
import com.mosi.shoppingCart.customer.domain.Customer;
import com.mosi.shoppingCart.customer.repository.CustomerRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest {
    @MockBean
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @Test
    void testGetAllCustomers() {
        ArrayList<Customer> customerList = new ArrayList<>();
        when(this.customerRepo.findAll()).thenReturn(customerList);

        List<Customer> actualAllCustomers = this.customerServiceImpl.getAllCustomers();
        assertSame(customerList, actualAllCustomers);

        assertTrue(actualAllCustomers.isEmpty());
        verify(this.customerRepo).findAll();
    }

    @Test
    void testGetCustomerById() {
        Cart cart = new Cart();
        cart.setCartLines(new ArrayList<>());

        Customer customer = new Customer();
        customer.setCart(cart);
        customer.setId("42");
        customer.setName("Name");
        customer.setPassword("iloveyou");
        customer.setUsername("janedoe");
        Optional<Customer> ofResult = Optional.of(customer);
        when(this.customerRepo.findById((String) any())).thenReturn(ofResult);
        Optional<Customer> actualCustomerById = this.customerServiceImpl.getCustomerById("42");
        assertSame(ofResult, actualCustomerById);
        assertTrue(actualCustomerById.isPresent());
        verify(this.customerRepo).findById((String) any());
    }

    @Test
    void testAddCustomer() {
        Cart cart = new Cart();
        cart.setCartLines(new ArrayList<>());

        Customer customer = new Customer();
        customer.setCart(cart);
        customer.setId("42");
        customer.setName("Name");
        customer.setPassword("iloveyou");
        customer.setUsername("janedoe");
        when(this.customerRepo.save((Customer) any())).thenReturn(customer);

        Cart cart1 = new Cart();
        cart1.setCartLines(new ArrayList<>());

        Customer customer1 = new Customer();
        customer1.setCart(cart1);
        customer1.setId("42");
        customer1.setName("Name");
        customer1.setPassword("iloveyou");
        customer1.setUsername("janedoe");
        assertSame(customer, this.customerServiceImpl.addCustomer(customer1));
        verify(this.customerRepo).save((Customer) any());
    }

    @Test
    void testUpdateCustomer() {
        Cart cart = new Cart();
        cart.setCartLines(new ArrayList<>());

        Customer customer = new Customer();
        customer.setCart(cart);
        customer.setId("42");
        customer.setName("Name");
        customer.setPassword("iloveyou");
        customer.setUsername("janedoe");
        when(this.customerRepo.save((Customer) any())).thenReturn(customer);

        Cart cart1 = new Cart();
        cart1.setCartLines(new ArrayList<>());

        Customer customer1 = new Customer();
        customer1.setCart(cart1);
        customer1.setId("42");
        customer1.setName("Name");
        customer1.setPassword("iloveyou");
        customer1.setUsername("janedoe");
        assertSame(customer, this.customerServiceImpl.updateCustomer("42", customer1));
        verify(this.customerRepo).save((Customer) any());
    }

    @Test
    void testFindByUsernameAndAndPassword() {
        Cart cart = new Cart();
        cart.setCartLines(new ArrayList<>());

        Customer customer = new Customer();
        customer.setCart(cart);
        customer.setId("42");
        customer.setName("Name");
        customer.setPassword("iloveyou");
        customer.setUsername("janedoe");
        Optional<Customer> ofResult = Optional.of(customer);
        when(this.customerRepo.findByUsernameAndAndPassword((String) any(), (String) any())).thenReturn(ofResult);
        Optional<Customer> actualFindByUsernameAndAndPasswordResult = this.customerServiceImpl
                .findByUsernameAndAndPassword("janedoe", "iloveyou");
        assertSame(ofResult, actualFindByUsernameAndAndPasswordResult);
        assertTrue(actualFindByUsernameAndAndPasswordResult.isPresent());
        verify(this.customerRepo).findByUsernameAndAndPassword((String) any(), (String) any());
    }
}

