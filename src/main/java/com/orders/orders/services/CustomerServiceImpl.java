package com.orders.orders.services;

import com.orders.orders.model.Customer;
import com.orders.orders.model.Order;
import com.orders.orders.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customer")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository custrepos;

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustById(long id) {
        return custrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Customer findCustByName(String name) {
        Customer customer = custrepos.findByName(name);
        if (customer == null){
            throw new EntityNotFoundException("Agent " + name + " not found!");
        }
        return customer;
    }

    @Transactional
    @Override
    public void delete(long id) {
        if(custrepos.findById(id).isPresent()){
            custrepos.deleteById(id);
        } else
            throw new EntityNotFoundException(Long.toString(id));

    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setRecieveamt(customer.getRecieveamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());

        for(Order o : customer.getOrders()) {
            newCustomer.getOrders().add(new Order(o.getOrdamount(), o.getAdvanceamount(), o.getCustcode(), o.getOrddescription(), newCustomer));
        }

        return custrepos.save(newCustomer);
    }

    @Transactional
    @Override
    public Customer update(Customer customer, long id) {
        return null;
    }
}
