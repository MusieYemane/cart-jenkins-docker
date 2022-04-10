package com.mosi.shoppingCart.order.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mosi.shoppingCart.order.domain.Order;
import com.mosi.shoppingCart.order.repository.OrderRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OrderServiceImpl.class})
@ExtendWith(SpringExtension.class)
class OrderServiceImplTest {
    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Test
    void testAddOrder() {
        Order order = new Order();
        order.setCartLines(new ArrayList<>());
        order.setCustomerId("42");
        order.setDateCreated(LocalDate.ofEpochDay(1L));
        order.setOrderId("42");
        order.setOrderStatus("Order Status");
        when(this.orderRepository.save((Order) any())).thenReturn(order);

        Order order1 = new Order();
        order1.setCartLines(new ArrayList<>());
        order1.setCustomerId("42");
        order1.setDateCreated(LocalDate.ofEpochDay(1L));
        order1.setOrderId("42");
        order1.setOrderStatus("Order Status");
        assertSame(order, this.orderServiceImpl.addOrder(order1));
        verify(this.orderRepository).save((Order) any());
    }

    @Test
    void testAddOrder2() {
        Order order = new Order();
        order.setCartLines(new ArrayList<>());
        order.setCustomerId("42");
        order.setDateCreated(LocalDate.ofEpochDay(1L));
        order.setOrderId("42");
        order.setOrderStatus("Order Status");
        when(this.orderRepository.save((Order) any())).thenReturn(order);

        Order order1 = new Order();
        order1.setCartLines(new ArrayList<>());
        order1.setCustomerId("42");
        order1.setDateCreated(LocalDate.ofEpochDay(1L));
        order1.setOrderId("42");
        order1.setOrderStatus("Order Status");
        assertSame(order, this.orderServiceImpl.addOrder(order1));
        verify(this.orderRepository).save((Order) any());
    }

    @Test
    void testFindByCustomerId() {
        Order order = new Order();
        order.setCartLines(new ArrayList<>());
        order.setCustomerId("42");
        order.setDateCreated(LocalDate.ofEpochDay(1L));
        order.setOrderId("42");
        order.setOrderStatus("Order Status");
        Optional<Order> ofResult = Optional.of(order);
        when(this.orderRepository.findById((String) any())).thenReturn(ofResult);
        assertSame(order, this.orderServiceImpl.findByCustomerId("42"));
        verify(this.orderRepository).findById((String) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testFindByCustomerId2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.mosi.shoppingCart.order.service.impl.OrderServiceImpl.findByCustomerId(OrderServiceImpl.java:23)
        //   In order to prevent findByCustomerId(String)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findByCustomerId(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.orderRepository.findById((String) any())).thenReturn(Optional.empty());
        this.orderServiceImpl.findByCustomerId("42");
    }

    @Test
    void testFindByCustomerId3() {
        Order order = new Order();
        order.setCartLines(new ArrayList<>());
        order.setCustomerId("42");
        order.setDateCreated(LocalDate.ofEpochDay(1L));
        order.setOrderId("42");
        order.setOrderStatus("Order Status");
        Optional<Order> ofResult = Optional.of(order);
        when(this.orderRepository.findById((String) any())).thenReturn(ofResult);
        assertSame(order, this.orderServiceImpl.findByCustomerId("42"));
        verify(this.orderRepository).findById((String) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testFindByCustomerId4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.mosi.shoppingCart.order.service.impl.OrderServiceImpl.findByCustomerId(OrderServiceImpl.java:23)
        //   In order to prevent findByCustomerId(String)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findByCustomerId(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.orderRepository.findById((String) any())).thenReturn(Optional.empty());
        this.orderServiceImpl.findByCustomerId("42");
    }

    @Test
    void testGetAllOrdersByCustomer() {
        ArrayList<Order> orderList = new ArrayList<>();
        when(this.orderRepository.getAllOrdersByCustomer((String) any())).thenReturn(orderList);
        List<Order> actualAllOrdersByCustomer = this.orderServiceImpl.getAllOrdersByCustomer("42");
        assertSame(orderList, actualAllOrdersByCustomer);
        assertTrue(actualAllOrdersByCustomer.isEmpty());
        verify(this.orderRepository).getAllOrdersByCustomer((String) any());
    }

    @Test
    void testGetAllOrdersByCustomer2() {
        ArrayList<Order> orderList = new ArrayList<>();
        when(this.orderRepository.getAllOrdersByCustomer((String) any())).thenReturn(orderList);
        List<Order> actualAllOrdersByCustomer = this.orderServiceImpl.getAllOrdersByCustomer("42");
        assertSame(orderList, actualAllOrdersByCustomer);
        assertTrue(actualAllOrdersByCustomer.isEmpty());
        verify(this.orderRepository).getAllOrdersByCustomer((String) any());
    }
}

