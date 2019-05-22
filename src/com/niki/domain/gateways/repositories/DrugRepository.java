package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Drug;

import java.util.List;


public interface DrugRepository {

    List<Drug> getDrugs();

    void saveDrugs(List<Drug> drugs);
}
