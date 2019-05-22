package com.niki.domain.interactors.catalog.intake;

import com.niki.domain.entities.Drug;

import java.util.List;

public interface IntakeItemInteractor {
    List<IntakeItemContract> get();

    List<Drug> getDrugs();

    void save(List<IntakeItemContract> contracts);
}
