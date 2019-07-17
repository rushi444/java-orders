package com.orders.orders.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Order")
public class Order {
    private long ordnum;

    private double ordamount;
    private double advanceamount;
    private long custcode;
    private String orddescription;

}
