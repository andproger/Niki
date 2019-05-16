package com.niki.data.cache.datastores.base;


import com.niki.data.cache.Sql;
import com.niki.data.cache.utils.SqlGen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.function.ToIntFunction;

import static com.niki.data.cache.utils.Utils.*;

public abstract class SqlDataStore<T> implements DataStore<T> {
    protected Connection connection;
    //TODO inject database name
    private String database = "drugs.dbo";

    private final String table;
    public final String[] columns;
    private final String[] columnsNoKey;
    private final String primaryKey; //TODO only integer type for primaryKey

    private final SqlGen sqlGen;

    public SqlDataStore(String tablename, String[] columns, String primaryKey) {
        this.table = tablename;

        this.primaryKey = primaryKey;
        this.columns = columns;
        this.columnsNoKey = filterNot(columns, primaryKey);

        sqlGen = new SqlGen(database, table, columns, primaryKey);

        this.connection = Sql.getIntent().getConnection();
    }

    @Override
    public void save(ArrayList<T> items) {
        items.sort(Comparator.comparingInt(getPrimaryKeyExtractor()));

        var itemsToInsert = new ArrayList<T>();
        var itemsToUpdate = new ArrayList<T>();
        var itemsToDelete = new ArrayList<Integer>();

        var dbItems = getAll();

        for (var country : items) {
            if (getPrimaryKey(country) != 0)
                itemsToUpdate.add(country);
            else
                itemsToInsert.add(country);
        }

        for (var dbCountry : dbItems) {
            if (search(items, dbCountry, getPrimaryKeyExtractor())) {
                itemsToDelete.add(getPrimaryKey(dbCountry));
            }
        }

        var sqlDelete = sqlGen.delete("where " + primaryKey + " in (" + idsDivided(itemsToDelete) + ")");
        var sqlInsert = sqlGen.insert();
        var sqlUpdate = sqlGen.update(" where " + primaryKey + " = ?");

        deleteItems(itemsToDelete, sqlDelete);
        insertItems(itemsToInsert, sqlInsert);
        updateItems(itemsToUpdate, sqlUpdate);
    }

    @Override
    public ArrayList<T> getAll() {
        var sqlSelect = sqlGen.select(null, "order by " + primaryKey);

        return select(sqlSelect);
    }

    protected ArrayList<T> select(String sqlQuery) {
        var items = new ArrayList<T>();

        try {
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

    protected void insertItems(ArrayList<T> items, String sqlQuery) {
        if (items.isEmpty()) return;

        try {
            var statement = this.connection.prepareStatement(sqlQuery);

            for (var item : items) {
                prepareInsert(statement, item);
                statement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void updateItems(ArrayList<T> items, String sqlQuery) {
        if (items.isEmpty()) return;

        try {
            var statement = this.connection.prepareStatement(sqlQuery);

            for (var item : items) {
                prepareUpdate(statement, item);
                statement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void deleteItems(ArrayList<Integer> ids, String sqlQuery) {
        if (ids.isEmpty()) return;

        try {
            var statement = connection.prepareStatement(sqlQuery);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean search(ArrayList<T> list, T item, ToIntFunction<? super T> keyExtractor) {
        return Collections.binarySearch(list, item, Comparator.comparingInt(keyExtractor)) < 0;
    }

    protected abstract ToIntFunction<? super T> getPrimaryKeyExtractor();

    protected abstract int getPrimaryKey(T item);

    protected abstract T fromResultSet(ResultSet result) throws SQLException;

    protected abstract void prepareInsert(PreparedStatement statement, T item) throws SQLException;

    protected abstract void prepareUpdate(PreparedStatement statement, T item) throws SQLException;
}
