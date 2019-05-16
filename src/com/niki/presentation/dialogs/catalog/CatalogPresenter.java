package com.niki.presentation.dialogs.catalog;

interface CatalogPresenter {
    void onAddClicked();
    void onDeleteClicked(int[] rows);
    void onSaveClicked();
}
