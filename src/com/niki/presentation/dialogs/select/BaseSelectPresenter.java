package com.niki.presentation.dialogs.select;

public abstract class BaseSelectPresenter implements SelectPresenter {
    protected final SelectView view;

    public BaseSelectPresenter(SelectView view) {
        this.view = view;
    }
}
