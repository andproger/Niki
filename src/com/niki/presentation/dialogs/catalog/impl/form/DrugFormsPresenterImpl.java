package com.niki.presentation.dialogs.catalog.impl.form;

import com.niki.domain.entities.Form;
import com.niki.domain.gateways.repositories.FormRepository;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;

import java.util.ArrayList;

public class DrugFormsPresenterImpl extends BaseCatalogPresenter {
    private final FormRepository formRepository;

    private DrugFormsTableModel tableModel;
    private ArrayList<Form> forms;

    public DrugFormsPresenterImpl(CatalogView view, FormRepository formRepository) {
        super(view);
        this.formRepository = formRepository;

        initTableModel();
    }

    private void initTableModel() {
        this.forms = formRepository.getForms();
        this.tableModel = new DrugFormsTableModel(forms);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        formRepository.saveForms(forms);
    }

    @Override
    public void onAddClicked() {
        forms.add(new Form(0, ""));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.forms.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
