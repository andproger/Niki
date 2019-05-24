package com.niki.data.cache.database.datastores.base;


import com.niki.data.cache.database.annotaion.Column;
import com.niki.data.cache.database.annotaion.IntPrimaryKey;
import com.niki.data.cache.database.annotaion.Table;
import com.niki.data.cache.database.connection.SqlConnector;
import com.niki.data.cache.database.utils.SqlGen;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

import static com.niki.data.cache.database.utils.Utils.idsDivided;

public abstract class SqlDataStore<T> implements DataStore<T> {
    private final static String DATABASE = "drugs.dbo";
    protected Connection connection;

    private final Class aClass;

    private final String table;
    private final List<String> columns;
    private final String primaryKey;

    private Field primaryField;
    private List<Field> columnFields;

    protected final SqlGen sqlGen;

    public SqlDataStore(Class aClass) {
        this.aClass = aClass;

        table = searchTableName();
        primaryKey = searchPrimaryKey();
        columns = searchColumns();

        sqlGen = new SqlGen(DATABASE, table, columns, primaryKey);

        this.connection = SqlConnector.getIntent().getConnection();
    }

    @Override
    public void save(List<T> items) {
        items.sort(Comparator.comparingInt(this::getPrimaryKeyInt));

        var itemsToInsert = new ArrayList<T>();
        var itemsToUpdate = new ArrayList<T>();
        var itemsIdsToDelete = new ArrayList<Integer>();

        var dbItems = getAll();

        for (var country : items) {
            if (getPrimaryKeyInt(country) != 0)
                itemsToUpdate.add(country);
            else
                itemsToInsert.add(country);
        }

        for (var dbCountry : dbItems) {
            if (search(items, dbCountry, this::getPrimaryKeyInt)) {
                itemsIdsToDelete.add(getPrimaryKeyInt(dbCountry));
            }
        }

        var sqlInsert = sqlGen.insert();
        var sqlUpdate = sqlGen.update(" where " + primaryKey + " = ?");

        deleteByIds(itemsIdsToDelete);
        insertItems(itemsToInsert, sqlInsert);
        updateItems(itemsToUpdate, sqlUpdate);
    }

    @Override
    public List<T> getAll() {
        var sqlSelect = sqlGen.select(null, "order by " + primaryKey);

        return select(sqlSelect);
    }

    protected List<T> select(String sqlQuery) {
        var items = new ArrayList<T>();

        try {
            var statement = this.connection.prepareStatement(sqlQuery);
            var result = statement.executeQuery();

            while (result.next()) {
                items.add(resultToItem(result));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    protected List<Integer> insertItems(List<T> items, String sqlQuery) {
        var result = new ArrayList<Integer>();

        if (items.isEmpty()) return result;

        try {
            String[] returnId = {"BATCHID"};
            var statement = this.connection.prepareStatement(sqlQuery, returnId);

            for (var item : items) {
                prepareInsert(statement, item);
                statement.executeUpdate();
            }
            var keys = statement.getGeneratedKeys();
            while (keys.next()) {
                result.add(keys.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    protected void updateItems(List<T> items, String sqlQuery) {
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

    protected void deleteByIds(List<Integer> ids) {
        if (ids.isEmpty()) return;

        var sqlQuery = sqlGen.delete("where " + primaryKey + " in (" + idsDivided(ids) + ")");

        try {
            var statement = connection.prepareStatement(sqlQuery);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getPrimaryKeyInt(T item) {
        try {
            return primaryField.getInt(item);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private T resultToItem(ResultSet result) throws SQLException, IllegalAccessException {
        T instance = newItemInstance();

        setInstance(instance, primaryField, result, primaryKey);

        for (int i = 0; i < columnFields.size(); i++) {
            setInstance(instance, columnFields.get(i), result, columns.get(i));
        }

        return instance;
    }

    protected void prepareInsert(PreparedStatement statement, T item) throws SQLException, IllegalAccessException {
        for (int i = 0; i < columnFields.size(); i++) {
            setStatement(statement, i + 1, columnFields.get(i), item);
        }
    }

    private void prepareUpdate(PreparedStatement statement, T item) throws SQLException, IllegalAccessException {
        for (int i = 0; i < columnFields.size(); i++) {
            setStatement(statement, i + 1, columnFields.get(i), item);
        }
        setStatement(statement, columnFields.size() + 1, primaryField, item);
    }

    private void setStatement(PreparedStatement statement, int index, Field field, T item) throws SQLException, IllegalAccessException {
        Class<?> clazz = field.getType();

        if (clazz.equals(String.class)) {
            statement.setString(index, (String) field.get(item));
        } else if (clazz.equals(Integer.TYPE)) {
            statement.setInt(index, field.getInt(item));
        } else if (clazz.equals(Double.TYPE)) {
            statement.setDouble(index, field.getDouble(item));
        } else if (clazz.equals(Long.TYPE)) {
            statement.setLong(index, field.getLong(item));
        } else if (clazz.equals(Boolean.TYPE)) {
            statement.setBoolean(index, field.getBoolean(item));
        } else if (clazz.equals(Date.class)) {
            statement.setDate(index, (Date) field.get(item));
        }
    }

    private void setInstance(T instance, Field field, ResultSet result, String column) throws SQLException, IllegalAccessException {
        Class<?> clazz = field.getType();

        if (clazz.equals(String.class)) {
            field.set(instance, result.getString(column));
        } else if (clazz.equals(Integer.TYPE)) {
            field.setInt(instance, result.getInt(column));
        } else if (clazz.equals(Double.TYPE)) {
            field.setDouble(instance, result.getDouble(column));
        } else if (clazz.equals(Long.TYPE)) {
            field.setLong(instance, result.getLong(column));
        } else if (clazz.equals(Boolean.TYPE)) {
            field.setBoolean(instance, result.getBoolean(column));
        } else if (clazz.equals(Date.class)) {
            field.set(instance, result.getDate(column));
        }
    }

    private String searchTableName() {
        Annotation[] annotations = aClass.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof Table) {
                Table t = (Table) annotation;
                return t.value();
            }
        }

        throw new IllegalStateException("not found @Table annotation in entity:" + aClass.getName());
    }

    private String searchPrimaryKey() {
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof IntPrimaryKey) {
                    if (!field.getType().equals(Integer.TYPE)) {
                        throw new IllegalStateException(field.getName() + "- primary key must be int in table:" + table + "; entity:" + aClass.getName());
                    }

                    IntPrimaryKey p = (IntPrimaryKey) annotation;

                    primaryField = field;
                    primaryField.setAccessible(true);

                    return p.value();
                }
            }
        }

        return null;
        //throw new IllegalStateException("not found field with primary key annotation in table:" + table + "; entity:" + aClass.getName());
    }

    private List<String> searchColumns() {
        List<String> list = new ArrayList<>();
        columnFields = new ArrayList<>();

        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Column) {

                    Column c = (Column) annotation;
                    list.add(c.value());

                    field.setAccessible(true);
                    columnFields.add(field);
                }
            }
        }

        return list;
    }

    private boolean search(List<T> list, T item, ToIntFunction<? super T> keyExtractor) {
        return Collections.binarySearch(list, item, Comparator.comparingInt(keyExtractor)) < 0;
    }

    protected abstract T newItemInstance();
}
