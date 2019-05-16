package com.niki.data.cache.datastores;


import com.niki.data.cache.datastores.base.SqlDataStore;
import com.niki.domain.entities.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.ToIntFunction;

public class SqlCountryDataStore extends SqlDataStore<Country> implements CountryDataStore {

    private static final String TABLE_NAME = "country";
    private static final String P_KEY = "id";
    private static final String[] COLUMNS = new String[]{P_KEY, "name", "code"};

    public SqlCountryDataStore() {
        super(TABLE_NAME, COLUMNS, P_KEY);
    }

    @Override
    protected int getPrimaryKey(Country item) {
        return item.getId();
    }

    @Override
    protected void prepareInsert(PreparedStatement statement, Country item) throws SQLException {
        statement.setString(1, item.getName());
        statement.setString(2, item.getCode());
    }

    @Override
    protected void prepareUpdate(PreparedStatement statement, Country item) throws SQLException {
        statement.setString(1, item.getName());
        statement.setString(2, item.getCode());
        statement.setInt(3, item.getId());
    }

    @Override
    protected Country fromResultSet(ResultSet result) throws SQLException {
        return new Country(
                result.getInt("id"),
                result.getString("name"),
                result.getString("code")
        );
    }

    @Override
    protected ToIntFunction<? super Country> getPrimaryKeyExtractor() {
        return Country::getId;
    }
}
