/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.util;

/**
 *
 * @author conan
 */
public class SqlFinderBean {

    public SqlFinderBean(String id, String sql) {
        this.id = id;
        this.sql = sql;
    }
    
    private String id;
    private String sql;
    private String parameter = "java.util.Map";
    private String result = "java.util.HashMap";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
