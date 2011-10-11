/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.util;

import org.conan.tools.util.match.JavaSQLMatch;

/**
 * 
 * @author Conan
 */
public class PropertyBean {

    private String name;
    private String type;
    private boolean _null;
    private boolean _unique;
    private String _default;

    public PropertyBean(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public PropertyBean(String name, String type, boolean _null) {
        this.name = name;
        this.type = type;
        this._null = _null;
    }

    public PropertyBean(String name, String type, boolean _null, boolean _unique, String _default) {
        this.name = name;
        this.type = type;
        this._null = _null;
        this._unique = _unique;
        this._default = _default;
    }

    public PropertyBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNull() {
        return _null;
    }

    public void setNull(boolean _null) {
        this._null = _null;
    }

    public String getTypeName() {
        return JavaSQLMatch.sql2JAVAShort(this.type) + " " + this.name;
    }

    public boolean isUnique() {
        return _unique;
    }

    public void setUnique(boolean _unique) {
        this._unique = _unique;
    }

    public String getDefault() {
        return _default;
    }

    public void setDefault(String _default) {
        this._default = _default;
    }

}
