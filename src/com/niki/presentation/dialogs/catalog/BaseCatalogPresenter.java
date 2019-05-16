package com.niki.presentation.dialogs.catalog;

public abstract class BaseCatalogPresenter implements CatalogPresenter {
    protected final CatalogView view;

    public BaseCatalogPresenter(CatalogView view) {
        this.view = view;
    }

    @Override
    public void onAddClicked() {

    }

    @Override
    public void onDeleteClicked() {

    }

    @Override
    public void onSaveClicked() {

    }
}
