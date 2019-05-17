package com.niki.data.cache.utils;

import java.util.List;

import static com.niki.data.cache.utils.Utils.*;

public class SqlGen {
    private final String database;

    private final String table;
    private final List<String> columns;
    private final List<String> allColumns;
    private final String primaryKey;

    public SqlGen(String database, String table, List<String> columns, String primaryKey) {
        this.database = database;
        this.table = table;
        this.primaryKey = primaryKey;

        this.columns = columns;
        this.allColumns = copyAddToStart(columns, primaryKey);
    }

    public String select(String where, String orderBy) {
        StringBuilder sb = new StringBuilder();

        sb.append("Select ");
        sb.append(Utils.columnsDivided(allColumns));
        sb.append(" From ").append(database).append(".[").append(table).append("]");

        if (where != null) sb.append(" ").append(where);
        if (orderBy != null) sb.append(" ").append(orderBy);

        return sb.toString();
    }

    public String insert() {
        StringBuilder sb = new StringBuilder();

        sb.append("Insert into ");
        sb.append(database).append(".[").append(table).append("]");
        sb.append(columnsToInsertParams(columns));

        return sb.toString();
    }

    public String update(String where) {
        StringBuilder sb = new StringBuilder();
        sb.append("Update ").append(database).append(".[").append(table).append("]");
        sb.append(" set ").append(columnsToSqlParams(columns));

        if (where != null) sb.append(" ").append(where);

        return sb.toString();
    }

    public String delete(String where) {
        StringBuilder sb = new StringBuilder();
        sb.append("Delete from ").append(database).append(".[").append(table).append("]");

        if (where != null) sb.append(" ").append(where);

        return sb.toString();
    }
}
