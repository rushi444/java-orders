package com.orders.orders.repos;

import com.orders.orders.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Customer, Long> {

}
