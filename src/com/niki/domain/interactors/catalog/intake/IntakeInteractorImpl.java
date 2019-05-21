package com.niki.domain.interactors.catalog.intake;

import com.niki.domain.entities.*;
import com.niki.domain.gateways.repositories.*;
import com.niki.domain.interactors.catalog.drug.DrugContract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntakeInteractorImpl implements IntakeInteractor {
    private final ProviderRepository providerRepository;
    private final IntakeRepository intakeRepository;

    public IntakeInteractorImpl(
            DrugRepository providerRepository,
            ClassRepository classRepository,
            FormRepository formRepository,
            StorageRepository storageRepository,
            ManufacturerRepository manufacturerRepository
    ) {
        this.providerRepository = providerRepository;
        this.classRepository = classRepository;
        this.formRepository = formRepository;
        this.storageRepository = storageRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public ArrayList<DrugContract> getDrugs() {
        var drugs = providerRepository.getDrugs();
        var classes = classRepository.getClasses();
        var forms = formRepository.getForms();
        var storages = storageRepository.getStorages();
        var manufacturers = manufacturerRepository.getManufacturers();

        var drugsResult = new ArrayList<DrugContract>();
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

            var manufacturer = new Manufacturer(drug.getManufacturerId(), 0, "", "");
            index = Collections.binarySearch(manufacturers, manufacturer, Comparator.comparingInt(Manufacturer::getId));
            manufacturer = index >= 0 ? manufacturers.get(index) : null;

            drugsResult.add(new DrugContract(
                    drug.getId(),
                    drug.getCost(),
                    drug.getName(),
                    drug.getDescription(),
                    drugClass,
                    manufacturer,
                    storage,
                    form)
            );
        }

        return drugsResult;
    }

    @Override
    public void saveDrugs(ArrayList<DrugContract> drugs) {
        var drugsResult = new ArrayList<com.niki.domain.entities.Drug>();
        for (var drug : drugs) {
            drugsResult.add(new com.niki.domain.entities.Drug(
                    drug.getId(),
                    drug.getCost(),
                    drug.getDrugClass().getId(),
                    drug.getManufacturer().getId(),
                    drug.getStorage().getId(),
                    drug.getForm().getId(),

                    drug.getName(),
                    drug.getDescription()
            ));
        }
        providerRepository.saveDrugs(drugsResult);
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

    @Override
    public ArrayList<Manufacturer> getManufacturers() {
        return manufacturerRepository.getManufacturers();
    }


}
