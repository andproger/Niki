package com.niki.presentation.dialogs.catalog.impl.storage;

import com.niki.domain.entities.Storage;
import com.niki.domain.gateways.repositories.StorageRepository;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;

import java.util.ArrayList;

public class StoragesPresenterImpl extends BaseCatalogPresenter {
    private final StorageRepository storageRepository;
    private ArrayList<Storage> storages;
    private StoragesTableModel tableModel;

    public StoragesPresenterImpl(CatalogView view, StorageRepository storageRepository) {
        super(view);
        this.storageRepository = storageRepository;

        initTableModel();
    }

    private void initTableModel() {
        this.storages = storageRepository.getStorages();
        this.tableModel = new StoragesTableModel(storages);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        storageRepository.saveStorages(storages);
    }

    @Override
    public void onAddClicked() {
        storages.add(new Storage(0, ""));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.storages.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
