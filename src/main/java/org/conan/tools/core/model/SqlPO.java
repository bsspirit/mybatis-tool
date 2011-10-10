/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author conan
 */
public class SqlPO extends FilePO {

    private String dbname;
    List<String> tables = new ArrayList<String>();

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

    public List<String> getTables() {
        return tables;
    }

}
