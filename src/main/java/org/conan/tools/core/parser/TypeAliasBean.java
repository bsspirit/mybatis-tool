package org.conan.tools.core.parser;

public class TypeAliasBean {

    public TypeAliasBean(String alias, String type) {
        this.alias = alias;
        this.type = type;
    }

    private String alias;
    private String type;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
