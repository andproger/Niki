package com.niki.presentation.dialogs.catalog.impl.indication;

import com.niki.domain.entities.Indication;
import com.niki.domain.gateways.repositories.IndicationRepository;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;

import java.util.List;

public class IndicationPresenterImpl extends BaseCatalogPresenter {
    private final IndicationRepository indicationRepository;

    private IndicationTableModel tableModel;
    private List<Indication> indications;

    public IndicationPresenterImpl(CatalogView view, IndicationRepository indicationRepository) {
        super(view);
        this.indicationRepository = indicationRepository;

        initTableModel();
    }

    private void initTableModel() {
        this.indications = indicationRepository.get();
        this.tableModel = new IndicationTableModel(indications);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        indicationRepository.save(indications);
    }

    @Override
    public void onAddClicked() {
        indications.add(new Indication(0, ""));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.indications.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
