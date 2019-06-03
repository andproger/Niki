package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.DrugCount;


public interface DrugCountRepository {
    DrugCount get(int drugId);
}
