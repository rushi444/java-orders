package com.orders.orders.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {
    private long custcode;

    private String custname;
    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private double openingamt;
    private double recieveamt;
    private double paymentamt;
    private double outstandingamt;
    private String phone;

    private List<Order> orders = new ArrayList<>();

    private Agent agent;
}
