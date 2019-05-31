package com.niki.presentation.dialogs.catalog.impl.provider;

import com.niki.domain.entities.Contact;
import com.niki.domain.interactors.catalog.provider.ProviderContract;
import com.niki.domain.interactors.catalog.provider.ProviderInteractor;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;

import java.util.List;

public class ProvidersPresenterImpl extends BaseCatalogPresenter {
    private final ProviderInteractor interactor;

    private ProvidersTableModel tableModel;
    private List<ProviderContract> providers;

    public ProvidersPresenterImpl(CatalogView view, ProviderInteractor interactor) {
        super(view);
        this.interactor = interactor;

        initTableModel();
    }

    private void initTableModel() {
        this.providers = interactor.get();
        this.tableModel = new ProvidersTableModel(providers);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        interactor.save(providers);
    }

    @Override
    public void onAddClicked() {
        providers.add(new ProviderContract(0, "", new Contact(0, "", "", "", "")));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.providers.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
