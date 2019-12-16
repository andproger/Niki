package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Bus;
import com.niki.domain.entities.BusBrand;

import java.util.List;

public interface BusBrandRepository {

    List<BusBrand> get();

    BusBrand get(int id);

    void save(List<BusBrand> items);
}
