package com.niki.presentation.dialogs.catalog.impl.country;

import com.niki.domain.entities.Country;
import com.niki.domain.interactors.catalog.country.CountryInteractor;
import com.niki.presentation.dialogs.catalog.BaseCatalogPresenter;
import com.niki.presentation.dialogs.catalog.CatalogView;

import java.util.ArrayList;

public class CountriesPresenterImpl extends BaseCatalogPresenter {
    private CountryInteractor countryInteractor;
    private CountriesTableModel tableModel;
    private ArrayList<Country> countries;
    public CountriesPresenterImpl(CatalogView view, CountryInteractor countryInteractor){
        super(view);
        this.countryInteractor = countryInteractor;
        initTableModel();
    }

    private void initTableModel() {
        this.countries = countryInteractor.getCountries();
        this.tableModel = new CountriesTableModel(countries);
        view.setTableModel(tableModel);
    }

    @Override
    public void onSaveClicked() {
        countryInteractor.saveCountries(countries);
    }

    @Override
    public void onAddClicked() {
        countries.add(new Country(0, "", ""));
        tableModel.fireTableDataChanged();
    }
}
