package com.niki.presentation.dialogs.catalog.impl.intake;

import com.niki.data.repository.IntakeRepositorySql;
import com.niki.domain.entities.Drug;
import com.niki.domain.entities.Intake;
import com.niki.domain.interactors.catalog.intake.IntakeItemContract;
import com.niki.domain.interactors.catalog.intake.IntakeItemInteractor;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;
import com.niki.presentation.dialogs.catalog.CellEditor;

import java.util.ArrayList;

public class NewIntakeItemsPresenterImpl extends BaseCatalogPresenter {

    private final IntakeRepositorySql intakeRepositorySql;
    private final IntakeItemInteractor intakeItemInteractor;
    private int providerId;

    private ArrayList<IntakeItemContract> itemContracts;
    NewIntakeItemsTableModel tableModel;

    public NewIntakeItemsPresenterImpl(CatalogView view, int providerId, IntakeRepositorySql intakeRepositorySql,
                                       IntakeItemInteractor intakeItemInteractor) {
        super(view);
        this.intakeItemInteractor = intakeItemInteractor;
        this.intakeRepositorySql = intakeRepositorySql;
        this.providerId = providerId;
        initTableModel();
    }

    private void initTableModel() {
        this.itemContracts = new ArrayList<>();
        this.tableModel = new NewIntakeItemsTableModel(itemContracts);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Drug.class, new CellEditor<>(intakeItemInteractor.getDrugs()));
    }

    @Override
    public void onSaveClicked() {
        int intakeId = intakeRepositorySql.save(new Intake(0, providerId, ((int) System.currentTimeMillis() / 1000)));
        for (var item : itemContracts) {
            item.setIntakeId(intakeId);
        }
        intakeItemInteractor.save(itemContracts);
    }

    @Override
    public void onAddClicked() {
        itemContracts.add(new IntakeItemContract(0, null, 0, 0));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.itemContracts.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
