package com.niki.presentation.dialogs.simpleView.impl.user.create;

import com.niki.domain.gateways.repositories.PersonRepository;

public class CreateUserPresenterImpl implements CreateUserPresenter {
    private final CreateUserView view;
    private final PersonRepository personRepository;


    CreateUserPresenterImpl(CreateUserView view, PersonRepository personRepository) {
        this.view = view;
        this.personRepository = personRepository;
        initViews();
    }

    private void initViews() {
        this.view.initViews(personRepository.get());
    }
}
