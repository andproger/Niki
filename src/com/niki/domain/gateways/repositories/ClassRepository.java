package com.niki.domain.gateways.repositories;

import com.niki.domain.entities.DrugClass;

import java.util.List;


public interface ClassRepository {

    List<DrugClass> getClasses();

    void saveClasses(List<DrugClass> countries);
}
