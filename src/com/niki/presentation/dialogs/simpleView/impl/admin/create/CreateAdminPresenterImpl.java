package com.niki.presentation.dialogs.simpleView.impl.admin.create;

import com.niki.domain.gateways.repositories.PersonRepository;

public class CreateAdminPresenterImpl implements CreateAdminPresenter {
    private final CreateAdminView view;
    private final PersonRepository personRepository;


    CreateAdminPresenterImpl(CreateAdminView view, PersonRepository personRepository) {
        this.view = view;
        this.personRepository = personRepository;
        initViews();
    }

    private void initViews() {
        this.view.initViews(personRepository.get());
    }
}
