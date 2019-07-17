package com.orders.orders.model;

import javax.persistence.Entity;
import javax.persistence.Table;

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

    private Agent agent;
}
