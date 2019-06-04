package com.niki.domain.interactors.catalog.drug;

import com.niki.domain.entities.DrugClass;
import com.niki.domain.entities.Form;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.entities.Storage;
import com.niki.domain.gateways.repositories.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DrugInteractorImpl implements DrugInteractor {
    private final DrugRepository drugRepository;
    private final ClassRepository classRepository;
    private final FormRepository formRepository;
    private final StorageRepository storageRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final DrugCountRepository drugCountRepository;

    public DrugInteractorImpl(
            DrugRepository drugRepository,
            ClassRepository classRepository,
            FormRepository formRepository,
            StorageRepository storageRepository,
            ManufacturerRepository manufacturerRepository,
            DrugCountRepository drugCountRepository) {
        this.drugRepository = drugRepository;
        this.classRepository = classRepository;
        this.formRepository = formRepository;
        this.storageRepository = storageRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.drugCountRepository = drugCountRepository;
    }

    @Override
    public ArrayList<DrugContract> getDrugs() {
        var drugs = drugRepository.getDrugs();
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

            var manufacturer = new Manufacturer(drug.getManufacturerId(), 0, "", 0);
            index = Collections.binarySearch(manufacturers, manufacturer, Comparator.comparingInt(Manufacturer::getId));
            manufacturer = index >= 0 ? manufacturers.get(index) : null;

            var drugCount = drugCountRepository.get(drug.getId());

            drugsResult.add(new DrugContract(
                    drug.getId(),
                    drug.getCost(),
                    drug.getName(),
                    drug.getDescription(),
                    drugClass,
                    manufacturer,
                    storage,
                    form,
                    drugCount)
            );
        }

        return drugsResult;
    }

    @Override
    public void saveDrugs(List<DrugContract> drugs) {
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
        drugRepository.saveDrugs(drugsResult);
    }

    @Override
    public List<Form> getForms() {
        return formRepository.getForms();
    }

    @Override
    public List<Storage> getStorages() {
        return storageRepository.getStorages();
    }

    @Override
    public List<DrugClass> getClasses() {
        return classRepository.getClasses();
    }

    @Override
    public List<Manufacturer> getManufacturers() {
        return manufacturerRepository.getManufacturers();
    }


}
