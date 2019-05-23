package com.niki.presentation.dialogs.catalog.impl.intake;

import com.niki.domain.entities.Drug;
import com.niki.domain.gateways.repositories.DrugRepository;
import com.niki.domain.interactors.catalog.intake.IntakeInteractor;
import com.niki.domain.interactors.catalog.intake.IntakeItemContract;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;
import com.niki.presentation.dialogs.catalog.CellEditor;

import java.util.ArrayList;

public class NewIntakeItemsPresenterImpl extends BaseCatalogPresenter {

    private final DrugRepository drugRepository;
    private final IntakeInteractor intakeInteractor;
    private int providerId;
    private int intakeId;
    private ArrayList<IntakeItemContract> intakeItems;
    private NewIntakeItemsTableModel tableModel;

    public NewIntakeItemsPresenterImpl(
            CatalogView view,
            int providerId,
            DrugRepository drugRepository,
            IntakeInteractor intakeInteractor
    ) {
        super(view);
        this.drugRepository = drugRepository;
        this.intakeInteractor = intakeInteractor;
        this.providerId = providerId;
        initTableModel();
    }

    private void initTableModel() {
        this.intakeId = 0;
        this.intakeItems = new ArrayList<>();
        this.tableModel = new NewIntakeItemsTableModel(intakeItems);
        view.setTableModel(tableModel);
        view.setTableCellEditor(Drug.class, new CellEditor<>(drugRepository.getDrugs()));
    }

    @Override
    public void onSaveClicked() {
        if (intakeId == 0) {
            if (!intakeItems.isEmpty()) {
                intakeId = intakeInteractor.add(providerId, intakeItems);
            }
        } else {
            if (!intakeItems.isEmpty()) {
                intakeInteractor.change(intakeId, intakeItems);
            } else {
                intakeInteractor.remove(intakeId);
            }
        }
    }

    @Override
    public void onAddClicked() {
        intakeItems.add(new IntakeItemContract(0, null, 0, 0));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.intakeItems.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
