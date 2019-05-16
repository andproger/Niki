package com.niki.data.cache.datastores;


import com.niki.data.cache.Sql;
import com.niki.data.cache.SqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.function.ToIntFunction;

import static com.niki.data.cache.SqlUtils.*;

public abstract class BaseDataStore<T> {
    protected Connection connection;
    private String database;

    private final String table;
    public final String[] columns;
    public final String[] columnsNoId;

    public BaseDataStore(String tablename, String[] columns) {
        this.table = tablename;

        this.columns = columns;
        this.columnsNoId = filterNot(columns, "id");

        this.connection = Sql.getIntent().getConnection();
    }

    public void save(ArrayList<T> items) {
        items.sort(Comparator.comparingInt(getKeyExtractor()));

        var itemsToInsert = new ArrayList<T>();
        var itemsToUpdate = new ArrayList<T>();
        var itemsToDelete = new ArrayList<Integer>();

        var dbItems = getAll();

        for (var country : items) {
            if (getId(country) != 0)
                itemsToUpdate.add(country);
            else
                itemsToInsert.add(country);
        }

        for (var dbCountry : dbItems) {
            if (search(items, dbCountry, getKeyExtractor())) {
                itemsToDelete.add(getId(dbCountry));
            }
        }

        deleteItems(itemsToDelete);
        insertItems(itemsToInsert);
        updateItems(itemsToUpdate);
    }

    public ArrayList<T> getAll() {
        var items = new ArrayList<T>();

        //TODO inject database name
        try {
            var sqlQuery = "Select " + SqlUtils.columnsDivided(columns) + " From drugs.dbo.[" + table + "] order by id";

            var statement = this.connection.prepareStatement(sqlQuery);
            var result = statement.executeQuery();
            while (result.next()) {
                items.add(fromResultSet(result));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    private void insertItems(ArrayList<T> items) {
        try {
            var sqlQuery = "insert into drugs.dbo.[" + table + "] " + columnsToInsertParams(columnsNoId);
            var statement = this.connection.prepareStatement(sqlQuery);

            for (var item : items) {
                insert(statement, item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateItems(ArrayList<T> items) {
        try {
            var sqlQuery = "update drugs.dbo.[" + table + "] set " + columnsToSqlParams(columnsNoId) + " where id = ?";
            var statement = this.connection.prepareStatement(sqlQuery);

            for (var item : items) {
                update(statement, item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteItems(ArrayList<Integer> ids) {
        if (ids.isEmpty()) return;

        try {
            var sqlQuery = "delete from drugs.dbo.[" + table + "] where id in (";
            for (int i = 0; i < ids.size(); i++) {
                sqlQuery += ids.get(i);
                if (i != ids.size() - 1)
                    sqlQuery += ", ";
            }
            sqlQuery += ")";

            var statement = connection.prepareStatement(sqlQuery);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean search(ArrayList<T> list, T item, ToIntFunction<? super T> keyExtractor) {
        return Collections.binarySearch(list, item, Comparator.comparingInt(keyExtractor)) < 0;
    }

    abstract ToIntFunction<? super T> getKeyExtractor();

    abstract int getId(T item);

    protected abstract T fromResultSet(ResultSet result) throws SQLException;

    protected abstract void insert(PreparedStatement statement, T item) throws SQLException;

    protected abstract void update(PreparedStatement statement, T item) throws SQLException;
}
