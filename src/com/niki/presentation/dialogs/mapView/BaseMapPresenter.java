package com.niki.presentation.dialogs.mapView;

public abstract class BaseMapPresenter implements MapPresenter {
    protected final MapView view;

    public BaseMapPresenter(MapView view) {
        this.view = view;
    }
}
