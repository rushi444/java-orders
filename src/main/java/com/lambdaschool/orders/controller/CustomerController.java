package com.lambdaschool.orders.controller;


import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.model.Orders;
import com.lambdaschool.orders.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    private CustomersService customersService;

    @GetMapping(value = "/order",
                produces = {"application/json"})
    public ResponseEntity<?> listAllCustomersOrders()
    {
        ArrayList<Customers> list = customersService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}",
                produces = {"applicaton/json"})
    public ResponseEntity<?> getOrdersByName(@PathVariable String name)
    {
        Customers c = customersService.findCustomerByName(name);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping(value = "/new",
                consumes = {"application/json"},
                produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customers newCustomer)
    {
        newCustomer = customersService.save(newCustomer);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{custcode}").buildAndExpand(newCustomer.getCustcode()).toUri();
        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(null, responseHeaders,HttpStatus.CREATED);
    }
}
