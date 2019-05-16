package com.niki.presentation.dialogs.catalog.impl.drug;

import com.niki.domain.entities.*;
import com.niki.domain.interactors.catalog.drug.DrugContract;
import com.niki.domain.interactors.catalog.drug.DrugInteractor;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;
import com.niki.presentation.dialogs.catalog.CellEditor;

import java.util.ArrayList;

public class DrugsPresenterImpl extends BaseCatalogPresenter {

    private final DrugInteractor drugInteractor;

    private DrugsTableModel tableModel;
    private ArrayList<DrugContract> drugs;

    public DrugsPresenterImpl(CatalogView view, DrugInteractor drugInteractor){
        super(view);
        this.drugInteractor = drugInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.drugs = drugInteractor.getDrugs();
        this.tableModel = new DrugsTableModel(drugs);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Storage.class, new CellEditor<>(drugInteractor.getStorages()));
        view.setTableCellEditor(Form.class, new CellEditor<>(drugInteractor.getForms()));
        view.setTableCellEditor(DrugClass.class, new CellEditor<>(drugInteractor.getClasses()));
    }

    @Override
    public void onSaveClicked() {
        drugInteractor.saveDrugs(drugs);
    }

    @Override
    public void onAddClicked() {
        drugs.add(new DrugContract(0, 0,"", "", null, null, null, null));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for(int i = rows.length - 1; i >= 0; i--)
            this.drugs.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
