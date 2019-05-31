package com.niki.presentation.dialogs.intake;

public interface NewIntakePresenter {
    void onSaveClicked(int providerId);
    void onAddClicked();
    void onDeleteClicked(int[] rows);
    void onTableChanged();
}
