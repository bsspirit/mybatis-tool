package org.conan.tools.core.build.tree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ResourceTree extends FolderTree {

    public ResourceTree(String root) {
        super(root);
    }

    // file name ///////////////////////////////////////////////////
    public String getSQLCreateName() {
        return "create" + SQL_FILE;
    }

    public String getSQLDropName() {
        return "drop" + SQL_FILE;
    }

    public String getMybatisName() {
        return "mybatis" + XML_FILE;
    }

    public String getSpringDAOName() {
        return "spring-dao" + XML_FILE;
    }

    public String getSpringServiceName() {
        return "spring-service" + XML_FILE;
    }

    // file folder /////////////////////////////////////////////////
    public String getSQLCreateFile() {
        return getSQLFolder() + File.separator + getSQLCreateName();
    }

    public String getSQLDropFile() {
        return getSQLFolder() + File.separator + getSQLDropName();
    }

    public String getMybatisFile() {
        return getResourceFolder() + File.separator + getMybatisName();
    }

    public String getSpringDAOFile() {
        return getResourceFolder() + File.separator + getSpringDAOName();
    }

    public String getSpringServiceFile() {
        return getResourceFolder() + File.separator + getSpringServiceName();
    }

    // file tree ///////////////////////////////////////////////////////////////
    public List<String> getTreeFile() {
        List<String> tree = new ArrayList<String>();
        tree.add(getSQLCreateFile());
        tree.add(getSQLDropFile());
        tree.add(getMybatisFile());
        tree.add(getSpringDAOFile());
        tree.add(getSpringServiceFile());
        return tree;
    }

}
