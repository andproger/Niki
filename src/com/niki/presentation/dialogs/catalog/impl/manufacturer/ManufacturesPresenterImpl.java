package com.niki.presentation.dialogs.catalog.impl.manufacturer;

import com.niki.domain.entities.Contact;
import com.niki.domain.entities.Country;
import com.niki.domain.interactors.catalog.manufacturer.ManufacturerContract;
import com.niki.domain.interactors.catalog.manufacturer.ManufacturerInteractor;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;
import com.niki.presentation.dialogs.catalog.CellEditor;

import java.util.List;

public class ManufacturesPresenterImpl extends BaseCatalogPresenter {
    private final ManufacturerInteractor manufacturerInteractor;

    private ManufacturesTableModel tableModel;
    private List<ManufacturerContract> manufacturers;

    public ManufacturesPresenterImpl(CatalogView view, ManufacturerInteractor manufacturerInteractor) {
        super(view);
        this.manufacturerInteractor = manufacturerInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.manufacturers = manufacturerInteractor.getManufacturers();
        this.tableModel = new ManufacturesTableModel(manufacturers);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Country.class, new CellEditor<>(manufacturerInteractor.getCountries()));
    }

    @Override
    public void onSaveClicked() {
        manufacturerInteractor.saveManufacturers(manufacturers);
    }

    @Override
    public void onAddClicked() {
        manufacturers.add(new ManufacturerContract(0, "", null, new Contact(0, "", "", "", "")));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.manufacturers.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
