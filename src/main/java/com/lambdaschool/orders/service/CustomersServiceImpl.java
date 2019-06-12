package com.lambdaschool.orders.service;

import com.lambdaschool.orders.model.Agents;
import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.model.Orders;
import com.lambdaschool.orders.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "customerService")
public class CustomersServiceImpl implements CustomersService
{
    @Autowired
    private CustomersRepository custrepos;

    @Override
    public ArrayList<Customers> findAll()
    {
        ArrayList<Customers> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustomerById(long id)
    {
        return null;
    }

    @Override
    public Customers findCustomerByName(String name)
    {
        Customers customer = custrepos.findByCustname(name);
        if(customer == null)
        {
            throw new EntityNotFoundException("Customer " + name + " not found!@!");
        }
        return customer;
    }

    @Override
    public void delete(long id)
    {

    }

    @Transactional
    @Override
    public Customers save(Customers customer)
    {
        Customers newCustomer = new Customers();
        Agents newAgent = new Agents();

        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());

        for(Orders o : customer.getOrders())
        {
            newCustomer.getOrders().add(new Orders(o.getOrdamount(),o.getAdvanceamount(),newCustomer,newAgent,o.getOrdersescription()));
        }
        return null;
    }

    @Override
    public Customers update(Customers customer, long id)
    {
        return null;
    }
}
