package com.niki.presentation.dialogs.catalog.impl.classes;

import com.niki.domain.entities.DrugClass;
import com.niki.domain.gateways.repositories.ClassRepository;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;

import java.util.ArrayList;

public class DrugClassesPresenterImpl extends BaseCatalogPresenter {
    private DrugClassesTableModel tableModel;
    private ArrayList<DrugClass> classes;
    private final ClassRepository repository;

    public DrugClassesPresenterImpl(CatalogView view, ClassRepository repository) {
        super(view);
        this.repository = repository;

        initTableModel();
    }

    private void initTableModel() {
        this.classes = repository.getClasses();
        this.tableModel = new DrugClassesTableModel(classes);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        repository.saveClasses(classes);
    }

    @Override
    public void onAddClicked() {
        classes.add(new DrugClass(0, ""));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.classes.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
