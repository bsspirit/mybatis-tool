/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.model;

import java.util.ArrayList;
import java.util.List;

import org.conan.tools.core.util.TableBean;

/**
 * 
 * @author conan
 */
public class SqlPO extends FilePO {

    private String dbname;
    List<TableBean> tables = new ArrayList<TableBean>();

    public SqlPO(String root, String dbname) {
        super(root);
        this.dbname = dbname;
    }

    public SqlPO() {
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public List<TableBean> getTables() {
        return tables;
    }

    public List<String> getTablesName() {
        List<String> list = new ArrayList<String>();
        for (TableBean table : tables) {
            list.add(table.getTable());
        }
        return list;
    }

}
