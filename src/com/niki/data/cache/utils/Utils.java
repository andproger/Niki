package com.niki.data.cache.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String columnsToSqlParams(List<String> columns) {
        //"name = ?, code = ?";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < columns.size(); i++) {
            sb.append(columns.get(i)).append(" = ?");

            if (i != columns.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    public static String columnsToInsertParams(List<String> columns) {
        //"(name, code)  values (?, ?)";
        StringBuilder sb = new StringBuilder();

        sb.append("(");
        for (int i = 0; i < columns.size(); i++) {
            sb.append(columns.get(i));

            if (i != columns.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");

        sb.append("  values (");
        for (int i = 0; i < columns.size(); i++) {
            sb.append("?");

            if (i != columns.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");

        return sb.toString();
    }

    public static String columnsDivided(List<String> columns) {
        //id, name, code
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < columns.size(); i++) {
            sb.append(columns.get(i));

            if (i != columns.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    public static String idsDivided(List<Integer> ids) {
        //1, 2, 3
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < ids.size(); i++) {
            s.append(ids.get(i));

            if (i != ids.size() - 1)
                s.append(", ");
        }

        return s.toString();
    }

    public static  <Y> List<Y> copyAddToStart(List<Y> items, Y item) {
        List<Y> list = new ArrayList<>();
        list.add(item);
        list.addAll(items);
        return list;
    }
}
