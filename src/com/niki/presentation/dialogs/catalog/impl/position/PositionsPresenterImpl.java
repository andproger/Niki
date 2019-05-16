package com.niki.presentation.dialogs.catalog.impl.position;

import com.niki.domain.entities.Position;
import com.niki.domain.gateways.repositories.PositionRepository;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;

import java.util.ArrayList;

public class PositionsPresenterImpl extends BaseCatalogPresenter {
    private final PositionRepository positionRepository;

    private PositionsTableModel tableModel;
    private ArrayList<Position> positions;

    public PositionsPresenterImpl(CatalogView view, PositionRepository positionRepository) {
        super(view);
        this.positionRepository = positionRepository;

        initTableModel();
    }

    private void initTableModel() {
        this.positions = positionRepository.getPositions();
        this.tableModel = new PositionsTableModel(positions);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        positionRepository.savePositions(positions);
    }

    @Override
    public void onAddClicked() {
        positions.add(new Position(0, 0, ""));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.positions.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
