package org.conan.tools.core.parser;

import java.util.ArrayList;
import java.util.List;

public class SqlBean {

    private List<TableBean> list = new ArrayList<TableBean>();

    public SqlBean(List<TableBean> tb) {
        list.addAll(tb);
    }

    public List<String> getSqlCreateTables() {
        List<String> l = new ArrayList<String>();
        for (TableBean tb : list) {
            l.add(tb.getSqlCreateTable());
        }
        return l;
    }

}
