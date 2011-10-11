package org.conan.tools.core.parser;

import java.util.ArrayList;
import java.util.List;

import org.conan.tools.core.model.SqlPO;

public class SqlBean {

    private List<TableBean> list = new ArrayList<TableBean>();

    public SqlBean(SqlPO po) {
        list.addAll(po.getTables());
    }

    public List<String> getSqlCreateTables() {
        List<String> l = new ArrayList<String>();
        for (TableBean tb : list) {
            l.add(tb.getSqlCreateTable());
        }
        return l;
    }

}
