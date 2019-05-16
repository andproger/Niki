package com.niki.data.cache.utils;

import static com.niki.data.cache.utils.Utils.*;

public class SqlGen {
    private final String database;

    private final String table;
    public final String[] columns;
    private final String[] columnsNoKey;
    private final String primaryKey;

    public SqlGen(String database, String table, String[] columns, String primaryKey) {
        this.database = database;
        this.table = table;
        this.columns = columns;
        this.columnsNoKey = filterNot(columns, primaryKey);
        this.primaryKey = primaryKey;
    }

    public String select(String where, String orderBy) {
        StringBuilder sb = new StringBuilder();

        sb.append("Select ");
        sb.append(Utils.columnsDivided(columns));
        sb.append(" From ").append(database).append(".[").append(table).append("]");

        if (where != null) sb.append(" ").append(where);
        if (orderBy != null) sb.append(" ").append(orderBy);

        return sb.toString();
    }

    public String insert() {
        StringBuilder sb = new StringBuilder();

        sb.append("Insert into ");
        sb.append(database).append(".[").append(table).append("]");
        sb.append(columnsToInsertParams(columnsNoKey));

        return sb.toString();
    }

    public String update(String where) {
        StringBuilder sb = new StringBuilder();
        sb.append("Update ").append(database).append(".[").append(table).append("]");
        sb.append(" set ").append(columnsToSqlParams(columnsNoKey));

        if (where != null) sb.append(" ").append(where);

        return sb.toString();
    }

    public String delete(String where){
        StringBuilder sb = new StringBuilder();
        sb.append("Delete from ").append(database).append(".[").append(table).append("]");

        if (where != null) sb.append(" ").append(where);

        return sb.toString();
    }
}
