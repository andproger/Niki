package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Ticket;

import java.util.List;

public interface TicketRepository {

    List<Ticket> get();

    Ticket get(int id);

    void save(List<Ticket> items);
}
