package com.niki.presentation.dialogs.sale;

public interface NewSalePresenter {
    void onOkClicked(int providerId);
    void onAddClicked();
    void onDeleteClicked(int[] rows);
}
