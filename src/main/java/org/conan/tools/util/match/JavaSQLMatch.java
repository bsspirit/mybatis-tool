package org.conan.tools.util.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaSQLMatch {
    static List<JavaSQL> type = new ArrayList<JavaSQL>();
    static {
        type.add(new JavaSQL("java.lang.String", "varchar"));
        type.add(new JavaSQL("java.lang.String", "text"));
        type.add(new JavaSQL("java.lang.Integer", "int"));
        type.add(new JavaSQL("java.lang.Float", "float"));
        type.add(new JavaSQL("java.lang.Long", "long"));
        type.add(new JavaSQL("java.lang.Boolean", "boolean"));
        type.add(new JavaSQL("java.sql.Timestamp", "timestamp"));
        type.add(new JavaSQL("java.util.Date", "date"));
    }

    public static String java2SQL(String java) {
        Map<String, String> map = new HashMap<String, String>();
        for (JavaSQL js : type) {
            map.put(js.java, js.sql);
        }
        return map.get(java);
    }

    public static String sql2JAVA(String sql) {
        for (JavaSQL js : type) {
            if (sql.toLowerCase().contains(js.sql)) {
                return js.java;
            }
        }
        return null;
    }

    public static String sql2JAVAShort(String sql) {
        String java = sql2JAVA(sql);
        return java.substring(java.lastIndexOf(".") + 1);
    }

    public static boolean isJavaImport(String sql) {
        return !sql2JAVA(sql).contains("java.lang");
    }

}

class JavaSQL {
    public JavaSQL(String java, String sql) {
        this.java = java;
        this.sql = sql;
    }

    protected String java;
    protected String sql;
}
