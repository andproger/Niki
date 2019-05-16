package com.niki.domain.interactors.catalog.drug;

import com.niki.domain.entities.DrugClass;
import com.niki.domain.entities.Form;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.entities.Storage;

import java.util.ArrayList;

public interface DrugInteractor {
    ArrayList<DrugContract> getDrugs();

    void saveDrugs(ArrayList<DrugContract> drugs);

    ArrayList<Form> getForms();

    ArrayList<Storage> getStorages();

    ArrayList<DrugClass> getClasses();

    ArrayList<Manufacturer> getManufacturers();
}
