package com.niki.domain.interactors.catalog.drug;

import com.niki.domain.entities.DrugClass;
import com.niki.domain.entities.Form;
import com.niki.domain.entities.Storage;
import com.niki.domain.gateways.repositories.ClassRepository;
import com.niki.domain.gateways.repositories.DrugRepository;
import com.niki.domain.gateways.repositories.FormRepository;
import com.niki.domain.gateways.repositories.StorageRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DrugInteractorImpl implements DrugInteractor {
    private final DrugRepository drugRepository;
    private final ClassRepository classRepository;
    private final FormRepository formRepository;
    private final StorageRepository storageRepository;

    public DrugInteractorImpl(DrugRepository drugRepository, ClassRepository classRepository, FormRepository formRepository, StorageRepository storageRepository) {
        this.drugRepository = drugRepository;
        this.classRepository = classRepository;
        this.formRepository = formRepository;
        this.storageRepository = storageRepository;
    }

    @Override
    public ArrayList<Drug> getDrugs() {
        var drugs = drugRepository.getDrugs();
        var classes = classRepository.getClasses();
        var forms = formRepository.getForms();
        var storages = storageRepository.getStorages();

        var drugsResult = new ArrayList<Drug>();
        for (var drug : drugs) {

            var drugClass = new DrugClass(drug.getClassId(), "");
            var index = Collections.binarySearch(classes, drugClass, Comparator.comparingInt(DrugClass::getId));
            drugClass = index >= 0 ? classes.get(index) : null;

            var storage = new Storage(drug.getStorageId(), "");
            index = Collections.binarySearch(storages, storage, Comparator.comparingInt(Storage::getId));
            storage = index >= 0 ? storages.get(index) : null;

            var form = new Form(drug.getFormId(), "");
            index = Collections.binarySearch(forms, form, Comparator.comparingInt(Form::getId));
            form = index >= 0 ? forms.get(index) : null;

            drugsResult.add(new Drug(
                    drug.getId(),
                    drug.getCost(),
                    drug.getName(),
                    drug.getDescription(),
                    drugClass,
                    null,
                    storage,
                    form)
            );
        }

        return drugsResult;
    }

    @Override
    public void saveDrugs(ArrayList<Drug> drugs) {
        var drugsResult = new ArrayList<com.niki.domain.entities.Drug>();
        for (var drug : drugs) {
            drugsResult.add(new com.niki.domain.entities.Drug(
                    drug.getId(),
                    drug.getCost(),
                    drug.getDrugClass().getId(),
                    0,
                    drug.getStorage().getId(),
                    drug.getForm().getId(),

                    drug.getName(),
                    drug.getDescription()
            ));
        }
        drugRepository.saveDrugs(drugsResult);
    }

    @Override
    public ArrayList<Form> getForms() {
        return formRepository.getForms();
    }

    @Override
    public ArrayList<Storage> getStorages() {
        return storageRepository.getStorages();
    }

    @Override
    public ArrayList<DrugClass> getClasses() {
        return classRepository.getClasses();
    }
}
