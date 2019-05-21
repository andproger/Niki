package com.niki.presentation.dialogs.catalog.impl.provider;

import com.niki.domain.entities.Country;
import com.niki.domain.entities.Provider;
import com.niki.domain.gateways.repositories.ProviderRepository;
import com.niki.domain.interactors.catalog.manufacturer.ManufacturerContract;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;
import com.niki.presentation.dialogs.catalog.CellEditor;
import com.niki.presentation.dialogs.catalog.impl.manufacturer.ManufacturesTableModel;

import java.util.ArrayList;

public class ProvidersPresenterImpl extends BaseCatalogPresenter {
    private final ProviderRepository repository;

    private ProvidersTableModel tableModel;
    private ArrayList<Provider> providers;

    public ProvidersPresenterImpl(CatalogView view, ProviderRepository repository) {
        super(view);
        this.repository = repository;

        initTableModel();
    }

    private void initTableModel() {
        this.providers = repository.get();
        this.tableModel = new ProvidersTableModel(providers);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        repository.save(providers);
    }

    @Override
    public void onAddClicked() {
        providers.add(new Provider(0, "", ""));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.providers.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
