/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.clazz;

/**
 *
 * @author Conan
 */
public class PropertyBean {

    private String name;
    private String type;
    private boolean _null;

    public PropertyBean(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public PropertyBean(String name, String type, boolean _null) {
        this.name = name;
        this.type = type;
        this._null = _null;
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
        return this.type + " " + this.name;
    }

    public String getFullType() {
        return "java.lang." + this.type;
    }
}
