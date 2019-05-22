package com.niki.domain.interactors.catalog.drug;

import com.niki.domain.entities.DrugClass;
import com.niki.domain.entities.Form;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.entities.Storage;

import java.util.List;

public interface DrugInteractor {
    List<DrugContract> getDrugs();

    void saveDrugs(List<DrugContract> drugs);

    List<Form> getForms();

    List<Storage> getStorages();

    List<DrugClass> getClasses();

    List<Manufacturer> getManufacturers();
}
