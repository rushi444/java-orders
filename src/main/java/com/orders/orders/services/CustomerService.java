package com.orders.orders.services;

import com.orders.orders.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findCustById(long id);

    Customer findCustByName(String name);

    void delete(long id);

    Customer save(Customer agent);

    Customer update(Customer customer, long id);

}
