package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Indication;

import java.util.List;

public interface IndicationRepository {

    List<Indication> get();

    void save(List<Indication> users);
}
