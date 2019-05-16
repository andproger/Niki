package com.niki.data.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SqlUtils {

    public static String columnsToSqlParams(String[] columns) {
        //"name = ?, code = ?";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < columns.length; i++) {
            sb.append(columns[i]).append(" = ?");

            if (i != columns.length - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    public static String columnsToInsertParams(String[] columns) {
        //"(name, code)  values (?, ?)";
        StringBuilder sb = new StringBuilder();

        sb.append("(");
        for (int i = 0; i < columns.length; i++) {
            sb.append(columns[i]);

            if (i != columns.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");

        sb.append("  values (");
        for (int i = 0; i < columns.length; i++) {
            sb.append("?");

            if (i != columns.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");

        return sb.toString();
    }

    public static String columnsDivided(String[] columns) {
        //id, name, code
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < columns.length; i++) {
            sb.append(columns[i]);

            if (i != columns.length - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    public static String[] filterNot(String[] columnsArr, String str) {
        List<String> list = Arrays.asList(columnsArr);
        list = list.stream().filter(s -> !s.equals(str)).collect(Collectors.toList());
        var removed = list.size() < columnsArr.length;
        var size = columnsArr.length - (removed ? 1 : 0);
        return list.toArray(new String[size]);
    }
}
