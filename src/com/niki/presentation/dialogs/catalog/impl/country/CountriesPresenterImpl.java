package com.niki.presentation.dialogs.catalog.impl.country;

import com.niki.domain.entities.Country;
import com.niki.domain.gateways.repositories.CountryRepository;
import com.niki.domain.interactors.catalog.drug.DrugContract;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountriesPresenterImpl extends BaseCatalogPresenter {
    private final CountryRepository countryRepository;

    private CountriesTableModel tableModel;
    private List<Country> countries;

    public CountriesPresenterImpl(CatalogView view, CountryRepository countryRepository){
        super(view);
        this.countryRepository = countryRepository;

        initTableModel();
    }

    private void initTableModel() {
        this.countries = countryRepository.getCountries();
        Collections.sort(countries, Comparator.comparing(Country::getName));

        this.tableModel = new CountriesTableModel(countries);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        countryRepository.saveCountries(countries);
    }

    @Override
    public void onAddClicked() {
        countries.add(new Country(0, "", ""));
        tableModel.fireTableDataChanged();
    }

    @Override
    public void onDeleteClicked(int[] rows) {
        for(int i = rows.length - 1; i >= 0; i--)
            this.countries.remove(rows[i]);

        tableModel.fireTableDataChanged();
    }
}
