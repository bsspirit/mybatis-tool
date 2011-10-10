package org.conan.tools.core.build;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ResourceTree extends FileTree {

    public ResourceTree(String model, PackageTree pack) {
        this.pack = pack;
        this.model = model;
    }


    // file name ///////////////////////////////////////////////////
    public String getSQLCreateName() {
        return "create" + SQL_FILE;
    }

    public String getSQLDropName() {
        return "drop" + SQL_FILE;
    }

    // file folder /////////////////////////////////////////////////
    public String getSQLCreateFile() {
        return pack.getSQLFolder() + File.separator + getSQLCreateName();
    }

    public String getSQLDropFile() {
        return pack.getSQLFolder() + File.separator + getSQLDropName();
    }

    // file tree ///////////////////////////////////////////////////////////////
    public List<String> getTreeFile() {
        List<String> tree = new ArrayList<String>();
        tree.add(getSQLCreateFile());
        tree.add(getSQLDropFile());
        return tree;
    }


}
