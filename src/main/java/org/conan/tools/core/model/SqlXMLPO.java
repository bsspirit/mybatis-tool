/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.conan.tools.core.clazz.PropertyBean;
import org.conan.tools.core.clazz.SqlFinderBean;

/**
 *
 * @author conan
 */
public class SqlXMLPO extends ClazzPO {

    String table;
    boolean mark;
    List<PropertyBean> property = new LinkedList<PropertyBean>();
    List<SqlFinderBean> finder = new ArrayList<SqlFinderBean>();

    public SqlXMLPO() {
    }

    public SqlXMLPO(String root, String basePackage, String module, String model, String table) {
        super(root, basePackage, module, model);
        this.table = table;
    }

    public List<PropertyBean> getProperty() {
        return property;
    }

    public List<SqlFinderBean> getFinder() {
        return finder;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }
}
