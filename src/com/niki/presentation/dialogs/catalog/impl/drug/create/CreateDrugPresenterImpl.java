package com.niki.presentation.dialogs.catalog.impl.drug.create;

import com.niki.domain.gateways.repositories.*;

public class CreateDrugPresenterImpl implements CreateDrugPresenter {
    private final CreateDrugView view;
    private final FormRepository formRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final StorageRepository storageRepository;
    private final ClassRepository classRepository;


    CreateDrugPresenterImpl(
            CreateDrugView view,
            FormRepository formRepository,
            ManufacturerRepository manufacturerRepository,
            StorageRepository storageRepository,
            ClassRepository classRepository) {
        this.view = view;
        this.formRepository = formRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.storageRepository = storageRepository;
        this.classRepository = classRepository;
        initViews();
    }

    private void initViews(){
        this.view.initViews(manufacturerRepository.getManufacturers(),
                storageRepository.getStorages(),
                formRepository.getForms(),
                classRepository.getClasses());
    }
}
