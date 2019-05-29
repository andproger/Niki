package com.niki.presentation.dialogs.catalog.impl.drug.create;

import com.niki.domain.entities.*;

import java.util.List;

public interface CreateDrugView {
    void initViews(List<Manufacturer> manufacturers, List<Storage> storages, List<Form> forms, List<DrugClass> classes);
}
