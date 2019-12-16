package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Bus;
import com.niki.domain.entities.BusModel;

import java.util.List;

public interface BusModelRepository {

    List<BusModel> get();

    BusModel get(int id);

    void save(List<BusModel> items);
}
