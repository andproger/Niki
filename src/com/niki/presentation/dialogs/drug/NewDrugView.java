package com.niki.presentation.dialogs.drug;

import com.niki.domain.entities.*;

import java.util.List;

public interface NewDrugView {
    void initViews(List<Manufacturer> manufacturers, List<Storage> storages, List<Form> forms, List<DrugClass> classes);
}
