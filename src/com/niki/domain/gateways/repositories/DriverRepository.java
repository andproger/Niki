package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Driver;

import java.util.List;

public interface DriverRepository {

    List<Driver> get();

    Driver get(int id);

    void save(List<Driver> items);
}
