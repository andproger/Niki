package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Bus;
import com.niki.domain.entities.BusColor;

import java.util.List;

public interface BusColorRepository {

    List<BusColor> get();

    BusColor get(int id);

    void save(List<BusColor> items);
}
