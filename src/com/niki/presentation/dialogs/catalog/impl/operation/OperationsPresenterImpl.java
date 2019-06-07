package com.niki.presentation.dialogs.catalog.impl.operation;

import com.niki.domain.entities.Operation;
import com.niki.domain.gateways.repositories.OperationRepository;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;

import java.util.List;

public class OperationsPresenterImpl extends BaseCatalogPresenter {
    private final OperationRepository operationRepository;

    private OperationsTableModel tableModel;
    private List<Operation> operations;

    public OperationsPresenterImpl(CatalogView view, OperationRepository operationRepository) {
        super(view);
        this.operationRepository = operationRepository;

        initTableModel();
        view.setControlsVisible(false);
    }

    private void initTableModel() {
        this.operations = operationRepository.get();
        this.tableModel = new OperationsTableModel(operations);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        operationRepository.save(operations);
    }

    @Override
    public void onAddClicked() {
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        tableModel.fireTableDataChanged();
    }
}
