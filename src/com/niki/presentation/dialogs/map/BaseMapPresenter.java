package com.niki.presentation.dialogs.map;

public abstract class BaseMapPresenter implements MapPresenter {
    protected final MapView view;

    public BaseMapPresenter(MapView view) {
        this.view = view;
    }
}
