package org.conan.tools.core.build.tree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.conan.tools.util.match.StringMatch;

/**
 * 
 * @author Conan
 */
public class PackageTree extends FolderTree {

    protected String basePackage;
    protected String module;

    public PackageTree(String root, String basePackage, String module) {
        super(root);
        this.module = module;
        this.basePackage = basePackage;
    }

    public String getBaseFolder() {
        String tmp = getSrcFolder() + File.separator + basePackage;
        return StringMatch.point2Separator(tmp);
    }

    public String getModuleFolder() {
        return getBaseFolder() + File.separator + module;
    }

    public String getDAOFolder() {
        return getModuleFolder() + File.separator + DAO;
    }

    public String getServiceFolder() {
        return getModuleFolder() + File.separator + SERVICE;
    }

    public String getServiceImplFolder() {
        return getServiceFolder() + File.separator + IMPL;
    }

    @Deprecated
    public String getIbatisFolder() {
        return getDAOFolder() + File.separator + IBATIS;
    }

    /*
     * sql file into DAO folder
     * 
     * @see getDAOFolder()
     */
    @Deprecated
    public String getIbatisSQLFolder() {
        return getIbatisFolder() + File.separator + SQL;
    }

    public String getModelFolder() {
        return getModuleFolder() + File.separator + MODEL;
    }

    @Deprecated
    public String getIbatisTestFolder() {
        return StringMatch.point2Separator(getTestFolder() + File.separator + basePackage) + File.separator + module + File.separator + DAO + File.separator + IBATIS;
    }

    public String getFormWebFolder() {
        return StringMatch.point2Separator(getWebFolder() + File.separator + basePackage) + File.separator + module + File.separator + WEB;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public String getModulePackage() {
        return this.basePackage + POINT + this.module;
    }

    public String getDAOPackage() {
        return getModulePackage() + POINT + DAO;
    }

    public String getServicePackage() {
        return getModulePackage() + POINT + SERVICE;
    }

    public String getServiceImplPackage() {
        return getServicePackage() + POINT + IMPL;
    }

    @Deprecated
    public String getIbatisPackage() {
        return getDAOPackage() + POINT + IBATIS;
    }

    public String getIbatisSQLPackage() {
        return getDAOPackage() + POINT + SQL;
    }

    public String getModelPackage() {
        return getModulePackage() + POINT + MODEL;
    }

    public String getFormWebPackage() {
        return getModulePackage() + POINT + WEB;
    }

    @Override
    public List<String> getTreeFile() {
        List<String> tree = new ArrayList<String>();
        tree.add(getBaseFolder());
        tree.add(getModuleFolder());
        tree.add(getDAOFolder());
        tree.add(getModelFolder());
        tree.add(getFormWebFolder());
        tree.add(getServiceFolder());
        tree.add(getServiceImplFolder());
        // tree.add(getIbatisFolder());
        // tree.add(getIbatisSQLFolder());
        // tree.add(getIbatisTestFolder());
        return tree;
    }

    public List<String> getTreePackage() {
        List<String> tree = new ArrayList<String>();
        tree.add(getBasePackage());
        tree.add(getModulePackage());
        tree.add(getDAOPackage());
        tree.add(getIbatisSQLPackage());
        tree.add(getModelPackage());
        tree.add(getFormWebPackage());
        tree.add(getServicePackage());
        tree.add(getServiceImplPackage());
        // tree.add(getIbatisPackage());
        return tree;
    }

    public String printTreePackage() {
        StringBuilder sb = new StringBuilder();
        for (String file : getTreePackage()) {
            sb.append(file + "\n");
        }
        return sb.toString();
    }

}
