package com.orders.orders.services;

import com.orders.orders.model.Agent;

import java.util.ArrayList;

public interface AgentService {

    ArrayList<Agent> findAll();

    Agent findAgentById(long id);

    Agent findAgentbyName(String name);

    void delete(long id);

    Agent save( Agent agent);

    Agent update(Agent agent, long id);
}
