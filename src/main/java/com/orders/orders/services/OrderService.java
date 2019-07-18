package com.orders.orders.services;

import com.orders.orders.model.Order;

import java.util.ArrayList;

public interface OrderService {

    ArrayList<Order> findAll();

    Order findOrderById(long id);

    void delete(long id);

    Order save(Order order);

    Order update(Order order, long id);


}
