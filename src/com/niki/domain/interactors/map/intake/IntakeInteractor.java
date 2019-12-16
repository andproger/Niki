package com.niki.domain.interactors.map.intake;

import com.niki.domain.interactors.simpleView.intake.IntakeContract;
import com.niki.domain.interactors.simpleView.intake.IntakeItemContract;

import java.util.ArrayList;

public interface IntakeInteractor {

    ArrayList<IntakeContract> get();

    ArrayList<IntakeItemContract> getItems(int intakeId);
}
