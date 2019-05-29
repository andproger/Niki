package com.niki.presentation.dialogs.catalog.impl.drug;

import com.niki.domain.entities.DrugClass;
import com.niki.domain.entities.Form;
import com.niki.domain.entities.Manufacturer;
import com.niki.domain.entities.Storage;
import com.niki.domain.interactors.catalog.drug.DrugContract;
import com.niki.domain.interactors.catalog.drug.DrugInteractor;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;
import com.niki.presentation.dialogs.catalog.CellEditor;
import com.niki.presentation.dialogs.catalog.impl.drug.create.CreateDrugDialog;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class DrugsPresenterImpl extends BaseCatalogPresenter {

    private final DrugInteractor drugInteractor;

    private DrugsTableModel tableModel;
    private List<DrugContract> drugs;

    public DrugsPresenterImpl(CatalogView view, DrugInteractor drugInteractor) {
        super(view);
        this.drugInteractor = drugInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.drugs = drugInteractor.getDrugs();
        Collections.sort(drugs, Comparator.comparing(DrugContract::getName));

        this.tableModel = new DrugsTableModel(drugs);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Storage.class, new CellEditor<>(drugInteractor.getStorages()));
        view.setTableCellEditor(Form.class, new CellEditor<>(drugInteractor.getForms()));
        view.setTableCellEditor(DrugClass.class, new CellEditor<>(drugInteractor.getClasses()));
        view.setTableCellEditor(Manufacturer.class, new CellEditor<>(drugInteractor.getManufacturers()));
    }

    @Override
    public void onSaveClicked() {
        drugInteractor.saveDrugs(drugs);
    }

    @Override
    public void onAddClicked() {
        var newDrugDialog = new CreateDrugDialog();
        newDrugDialog.pack();
        newDrugDialog.setVisible(true);
        var drug = newDrugDialog.getDrugContract();

        if (drug != null) {
            drugs.add(drug);
            tableModel.fireTableDataChanged();
        }
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.drugs.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
