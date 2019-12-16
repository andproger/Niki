package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Bus;

import java.util.List;

public interface BusRepository {

    List<Bus> get();

    Bus get(int busId);

    void save(List<Bus> buses);
}
