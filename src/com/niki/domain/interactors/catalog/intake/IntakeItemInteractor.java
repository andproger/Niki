package com.niki.domain.interactors.catalog.intake;

import java.util.ArrayList;

public interface IntakeItemInteractor {
    ArrayList<IntakeItemContract> get();

    void save(ArrayList<IntakeItemContract> contracts);
}
