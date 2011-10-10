package org.conan.tools.core.build;

import java.util.List;

abstract public class FileTree {

    static final String SRC = "src";
    static final String TEST = "test";
    static final String RES = "resource";
    static final String SQL = "sql";
    static final String WEB = "web";

    static final String DAO = "dao";
    static final String SERVICE = "service";
    static final String SERVICE_IMPL = "ServiceImpl";
    static final String IMPL = "impl";
    static final String IBATIS = "ibatis";
    static final String DAO_IBATIS = "DAOIbatis";
    static final String DAO_IBATIS_TEST = "DAOIbatisTest";
    static final String MODEL = "model";
    static final String DTO = "DTO";
    static final String FORM = "Form";
    static final String MODULE_DTO = "ModuleDTO";
    static final String POINT = ".";

    static final String SQL_FILE = ".sql";
    static final String XML_FILE = ".xml";
    static final String JAVA_FILE = ".java";

    protected PackageTree pack;
    protected String model;

    abstract public List<String> getTreeFile();

    public String printTreeFile() {
        StringBuilder sb = new StringBuilder();
        for (String file : getTreeFile()) {
            sb.append(file + "\n");
        }
        return sb.toString();
    }

    public PackageTree getPack() {
        return pack;
    }

    public void setPack(PackageTree pack) {
        this.pack = pack;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
