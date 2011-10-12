package org.conan.tools.core.build.tree;

import java.util.List;

abstract public class BaseTree {

    static final String SRC = "src";
    static final String TEST = "test";
    static final String RES = "resource";
    static final String SQL = "sql";
    static final String WEB = "web";
    static final String DAO = "dao";

    static final String DAO_I = "DAO";
    static final String DAO_IBATIS = "DAOIbatis";
    static final String DAO_IBATIS_TEST = "DAOIbatisTest";
    static final String SERVICE = "service";
    static final String SERVICE_IMPL = "ServiceImpl";
    static final String IMPL = "impl";
    static final String IBATIS = "ibatis";
    static final String MODEL = "model";
    static final String DTO = "DTO";
    static final String FORM = "Form";
    static final String MODULE_DTO = "ModuleDTO";
    static final String POINT = ".";

    static final String SQL_FILE = ".sql";
    static final String XML_FILE = ".xml";
    static final String JAVA_FILE = ".java";

    abstract public List<String> getTreeFile();

    public String printTreeFile() {
        StringBuilder sb = new StringBuilder();
        for (String file : getTreeFile()) {
            sb.append(file + "\n");
        }
        return sb.toString();
    }

}
