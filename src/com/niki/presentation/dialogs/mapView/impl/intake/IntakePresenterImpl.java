package com.niki.presentation.dialogs.mapView.impl.intake;

import com.niki.domain.interactors.simpleView.intake.IntakeContract;
import com.niki.domain.interactors.simpleView.intake.IntakeItemContract;
import com.niki.domain.interactors.map.intake.IntakeInteractor;
import com.niki.presentation.dialogs.mapView.BaseMapPresenter;
import com.niki.presentation.dialogs.mapView.MapView;

import java.util.ArrayList;

public class IntakePresenterImpl extends BaseMapPresenter {

    private final IntakeInteractor intakeInteractor;
    // private int providerId;
    private int intakeId;
    private ArrayList<IntakeContract> intakes;
    private ArrayList<IntakeItemContract> intakeItems;
    private IntakeItemTableModel intakeItemTableModel;
    private IntakeTableModel tableModel;

    public IntakePresenterImpl(
            MapView view,
            IntakeInteractor intakeInteractor
    ) {
        super(view);
        this.intakeInteractor = intakeInteractor;
        initTableModels();
    }

    private void initTableModels() {
        this.intakeId = 0;
        this.intakes = intakeInteractor.get();
        this.intakeItems = intakeInteractor.getItems(intakeId);

        this.intakeItemTableModel = new IntakeItemTableModel(intakeItems);
        this.tableModel = new IntakeTableModel(intakes);

        view.setItemTableModel(intakeItemTableModel);
        view.setTableModel(tableModel);
    }

    @Override
    public void selectionChanged(int index) {
        System.out.println(index);
        var intakeItemContracts = intakeInteractor.getItems(intakes.get(index).getId());
        intakeItems.clear();
        intakeItems.addAll(intakeItemContracts);
        intakeItemTableModel.fireTableDataChanged();
    }
}
