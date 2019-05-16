package com.niki.data.repository;

import com.niki.domain.entities.Drug;
import com.niki.domain.gateways.repositories.DrugRepository;

import java.util.ArrayList;

public class DrugRepositorySql implements DrugRepository {

    @Override
    public ArrayList<Drug> getDrugs() {
        var drugs = new ArrayList<Drug>();
        for (int i = 0; i < 10; i++)
            drugs.add(new Drug(i, 0, 0, 0, 0, 0, "TEST", "TEST 2"));
        return drugs;
    }

    @Override
    public void saveDrugs(ArrayList<Drug> drugs) {

    }
}
