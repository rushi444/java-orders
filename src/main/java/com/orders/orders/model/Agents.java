package com.orders.orders.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Agent")
public class Agents {
    private long agentcode;

    private String agentname;
    private String workingarea;
    private double commision;
    private String phone;
    private String country;

    private List<Customer> customers = new ArrayList<>();
}
