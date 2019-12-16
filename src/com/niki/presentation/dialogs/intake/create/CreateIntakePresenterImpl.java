package com.niki.presentation.dialogs.intake.create;

public class CreateIntakePresenterImpl implements CreateIntakePresenter {
    private final CreateIntakeView view;
    private final DrugRepository drugRepository;


    CreateIntakePresenterImpl(CreateIntakeView view, DrugRepository drugRepository) {
        this.view = view;
        this.drugRepository = drugRepository;
        initViews();
    }

    private void initViews() {
        this.view.initViews(drugRepository.getDrugs());
    }
}
