package com.niki.presentation.dialogs.intake;

import com.niki.domain.interactors.simpleView.intake.IntakeInteractor;
import com.niki.domain.interactors.simpleView.intake.IntakeItemContract;
import com.niki.presentation.dialogs.simpleView.CellEditor;
import com.niki.presentation.dialogs.intake.create.CreateIntakeDialog;

import java.util.ArrayList;

public class NewIntakePresenterImpl implements NewIntakePresenter {

    private final NewIntakeView view;
    private final DrugRepository drugRepository;
    private final IntakeInteractor intakeInteractor;
    private int intakeId;
    private ArrayList<IntakeItemContract> intakeItems;
    private NewIntakeTableModel tableModel;

    public NewIntakePresenterImpl(
            NewIntakeView view,
            DrugRepository drugRepository,
            IntakeInteractor intakeInteractor
    ) {
        this.view = view;
        this.drugRepository = drugRepository;
        this.intakeInteractor = intakeInteractor;
        initTableModel();
    }

    private void initTableModel() {
        this.intakeItems = new ArrayList<>();
        this.tableModel = new NewIntakeTableModel(intakeItems);
        view.initViews(intakeInteractor.getProvider());
        view.setTableModel(tableModel);
        view.setTableCellEditor(Drug.class, new CellEditor<>(drugRepository.getDrugs()));
    }

    @Override
    public void onSaveClicked(int providerId) {
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
        var dialog = new CreateIntakeDialog();
        dialog.pack();
        dialog.setVisible(true);

        var item = dialog.getContract();
        if (item != null) {
            intakeItems.add(item);
            tableModel.fireTableDataChanged();
        }
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.intakeItems.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }

    @Override
    public void onTableChanged() {
        updateSum();
    }

    private void updateSum() {
        view.setSum(String.valueOf(getSum()));
    }

    private double getSum() {
        double sum = 0;

        for (var item : intakeItems)
            sum += item.getCost() * item.getQuantity();

        return sum;
    }
}
