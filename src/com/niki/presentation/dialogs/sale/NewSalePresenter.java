package com.niki.presentation.dialogs.sale;

public interface NewSalePresenter {
    void onOkClicked();
    void onAddClicked();
    void onDeleteClicked(int[] rows);
    void onTableChanged();
}
