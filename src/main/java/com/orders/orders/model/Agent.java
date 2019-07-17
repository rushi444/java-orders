package com.orders.orders.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    @Column(unique = true, nullable = false)
    private String agentname;

    private String workingarea;
    private double commision;
    private String phone;
    private String country;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customer> customers = new ArrayList<>();

    
}
