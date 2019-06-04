package com.niki.presentation.dialogs.catalog.impl.user.create;

import com.niki.domain.gateways.repositories.PositionRepository;

public class CreateUserPresenterImpl implements CreateUserPresenter {
    private final CreateUserView view;
    private final PositionRepository positionRepository;


    CreateUserPresenterImpl(CreateUserView view, PositionRepository positionRepository) {
        this.view = view;
        this.positionRepository = positionRepository;
        initViews();
    }

    private void initViews() {
        this.view.initViews(positionRepository.get());
    }
}
