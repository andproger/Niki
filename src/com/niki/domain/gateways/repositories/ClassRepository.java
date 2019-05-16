package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.Country;
import com.niki.domain.entities.DrugClass;

import java.util.ArrayList;

public interface ClassRepository {

    ArrayList<DrugClass> getClasses();

    void saveClasses(ArrayList<DrugClass> countries);
}
