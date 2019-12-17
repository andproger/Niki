package com.niki.presentation.dialogs.select;

import java.util.List;

interface SelectPresenter {
    void onOkClicked();
    List getSelectedItems(int[] rows);
}
