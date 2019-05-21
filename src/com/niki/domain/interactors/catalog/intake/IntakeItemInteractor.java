package com.niki.domain.interactors.catalog.intake;

import com.niki.domain.entities.Drug;

import java.util.ArrayList;

public interface IntakeItemInteractor {
    ArrayList<IntakeItemContract> get();
    ArrayList<Drug> getDrugs();

    void save(ArrayList<IntakeItemContract> contracts);
}
