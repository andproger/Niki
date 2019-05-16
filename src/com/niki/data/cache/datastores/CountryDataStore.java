package com.niki.data.cache.datastores;


import com.niki.domain.entities.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.ToIntFunction;

public class CountryDataStore extends BaseDataStore<Country> {

    private static final String TABLE_NAME = "country";
    private static final String[] COLUMNS = new String[]{"id", "name", "code"};

    public CountryDataStore() {
        super(TABLE_NAME, COLUMNS);
    }

    @Override
    ToIntFunction<? super Country> getKeyExtractor() {
        return Country::getId;
    }

    @Override
    int getId(Country item) {
        return item.getId();
    }

    @Override
    protected void insert(PreparedStatement statement, Country item) throws SQLException {
        statement.setString(1, item.getName());
        statement.setString(2, item.getCode());
        statement.execute();
    }

    @Override
    protected void update(PreparedStatement statement, Country item) throws SQLException {
        statement.setString(1, item.getName());
        statement.setString(2, item.getCode());
        statement.setInt(3, item.getId());
        statement.execute();
    }

    @Override
    protected Country fromResultSet(ResultSet result) throws SQLException {
        return new Country(
                result.getInt("id"),
                result.getString("name"),
                result.getString("code")
        );
    }
}
