package com.niki.presentation.dialogs.intake;

import com.niki.domain.gateways.repositories.ProviderRepository;
import com.niki.domain.interactors.login.LoginInteractor;
import com.niki.presentation.dialogs.login.LoginView;

public class NewIntakePresenterImpl implements NewIntakePresenter {
    private final NewIntakeView view;
    private final ProviderRepository providerRepository;

    NewIntakePresenterImpl(
            NewIntakeView view,
            ProviderRepository providerRepository
    ) {
        this.view = view;
        this.providerRepository = providerRepository;
        initViews();
    }

    @Override
    public void onOkClicked(int providerId) {

    }

    private void initViews(){
        this.view.initViews(providerRepository.get());
    }
}
