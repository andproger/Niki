package com.niki.domain.interactors.catalog.intake;

import java.util.ArrayList;

public interface IntakeInteractor {
    ArrayList<IntakeContract> get();

    void save(ArrayList<IntakeContract> contracts);
}
