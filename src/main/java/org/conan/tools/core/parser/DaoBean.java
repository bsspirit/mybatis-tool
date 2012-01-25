package org.conan.tools.core.parser;

public class DaoBean {
    public DaoBean(String id, String value) {
        this.id = id;
        this.value = value;
    }

    private String id;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
