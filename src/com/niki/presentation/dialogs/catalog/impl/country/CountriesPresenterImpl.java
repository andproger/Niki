package com.niki.presentation.dialogs.catalog.impl.country;

import com.niki.domain.entities.Country;
import com.niki.domain.gateways.repositories.CountryRepository;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;

import java.util.ArrayList;

public class CountriesPresenterImpl extends BaseCatalogPresenter {
    private final CountryRepository countryRepository;

    private CountriesTableModel tableModel;
    private ArrayList<Country> countries;

    public CountriesPresenterImpl(CatalogView view, CountryRepository countryRepository){
        super(view);
        this.countryRepository = countryRepository;

        initTableModel();
    }

    private void initTableModel() {
        this.countries = countryRepository.getCountries();
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
}
