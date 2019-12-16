package com.niki.presentation.dialogs.simpleView;

public abstract class BaseCatalogPresenter implements CatalogPresenter {
    protected final CatalogView view;

    public BaseCatalogPresenter(CatalogView view) {
        this.view = view;
    }

    @Override
    public void onAddClicked() {

    }

    @Override
    public void onDeleteClicked(int[] rows) {

    }

    @Override
    public void onSaveClicked() {

    }
}
