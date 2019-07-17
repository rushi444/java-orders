package com.orders.orders.controllers;

import com.orders.orders.model.Customer;
import com.orders.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/order", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers() {
        List<Customer> myCustomers = customerService.findAll();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

    @GetMapping(value = "name/{name}", produces = "{application/json}")
    public ResponseEntity<?> getOrdersByName(@PathVariable String name) {
        Customer r = customerService.findCustByName(name);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @PostMapping(value = "/new", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customer newCustomer){
        newCustomer = customerService.save(newCustomer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{custcode}").buildAndExpand(newCustomer.getCustcode()).toUri();
        responseHeaders.setLocation(newCustomerURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

    }



}
