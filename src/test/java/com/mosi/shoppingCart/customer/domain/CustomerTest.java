package com.mosi.shoppingCart.customer.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CustomerTest {
    @Test
    void testConstructor() {
        Customer actualCustomer = new Customer("Name", "janedoe", "iloveyou");

        assertEquals("janedoe", actualCustomer.getUsername());
        assertEquals("iloveyou", actualCustomer.getPassword());
        assertEquals("Name", actualCustomer.getName());
        assertEquals(0.0d, actualCustomer.getCart().getTotalPrice());
    }
}

