package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Drug;

import java.util.ArrayList;

public interface DrugRepository {

    ArrayList<Drug> getDrugs();

    void saveDrugs(ArrayList<Drug> drugs);
}
