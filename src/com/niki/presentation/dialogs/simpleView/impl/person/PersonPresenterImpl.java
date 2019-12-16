package com.niki.presentation.dialogs.simpleView.impl.person;

import com.niki.domain.entities.Person;
import com.niki.domain.interactors.simpleView.person.PersonInteractor;
import com.niki.presentation.dialogs.simpleView.BaseCatalogPresenter;
import com.niki.presentation.dialogs.simpleView.CatalogView;

import java.util.List;

public class PersonPresenterImpl extends BaseCatalogPresenter {
    private final PersonInteractor personInteractor;

    private PersonTableModel tableModel;
    private List<Person> items;

    public PersonPresenterImpl(CatalogView view, PersonInteractor personInteractor) {
        super(view);
        this.personInteractor = personInteractor;

        initTableModel();
    }

    private void initTableModel() {
        this.items = personInteractor.get();
        this.tableModel = new PersonTableModel(items);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        personInteractor.save(items);
    }

    @Override
    public void onAddClicked() {
        items.add(new Person(0));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for (int i = rows.length - 1; i >= 0; i--)
            this.items.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
