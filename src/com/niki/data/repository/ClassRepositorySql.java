package com.niki.data.repository;

import com.niki.domain.entities.DrugClass;
import com.niki.domain.gateways.repositories.ClassRepository;

import java.util.ArrayList;

public class ClassRepositorySql implements ClassRepository {
    @Override
    public ArrayList<DrugClass> getClasses() {
        var classes = new ArrayList<DrugClass>();
        for (int i = 0; i < 10; i++)
            classes.add(new DrugClass(i, "TEST"));
        return classes;
    }

    @Override
    public void saveClasses(ArrayList<DrugClass> countries) {

    }
}
