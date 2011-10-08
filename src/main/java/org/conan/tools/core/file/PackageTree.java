package org.conan.tools.core.file;

import java.io.File;

import org.conan.tools.core.model.PackagePO;
import org.conan.tools.util.match.StringMatch;

/**
 * 
 * @author Conan
 */
public class PackageTree {

    public PackageTree(PackagePO po) {
        this.root = po.getRoot();
        this.basePackage = po.getBasePackage();
        this.module = po.getModule();
    }

    public static final String DAO = "dao";
    public static final String SERVICE = "service";
    public static final String IMPL = "impl";
    public static final String IBATIS = "ibatis";
    public static final String SQL = "sql";
    public static final String MODEL = "model";
    public static final String WEB = "web";
    public static final String POINT = ".";

    private String root;
    private String module;
    private String basePackage;

    public String getRootFolder() {
        return StringMatch.transfer2Separator(root);
    }

    public String getSrcFolder() {
        return getRootFolder() + File.separator + ProjectTree.SRC;
    }

    public String getWebFolder() {
        return getRootFolder() + File.separator + ProjectTree.WEB;
    }

    public String getTestFolder() {
        return getRootFolder() + File.separator + ProjectTree.TEST;
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

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getModule() {
        return module;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String[] getTreePackageArray() {
        String[] tree = new String[8];
        tree[0] = getBasePackage();
        tree[1] = getModulePackage();
        tree[2] = getDAOPackage();
        tree[3] = getIbatisSQLPackage();
        tree[4] = getModelPackage();
        tree[5] = getFormWebPackage();
        tree[6] = getServicePackage();
        tree[7] = getServiceImplPackage();
        // tree[3] = getIbatisPackage();
        return tree;
    }

    public String[] getTreeFolderArray() {
        String[] tree = new String[8];
        tree[0] = getRootFolder();
        tree[1] = getBaseFolder();
        tree[2] = getModuleFolder();
        tree[3] = getDAOFolder();
        tree[4] = getModelFolder();
        tree[5] = getFormWebFolder();
        tree[6] = getServiceFolder();
        tree[7] = getServiceImplFolder();
        // tree[4] = getIbatisFolder();
        // tree[5] = getIbatisSQLFolder();
        // tree[7] = getIbatisTestFolder();
        return tree;
    }

    public String printTreePackage() {
        StringBuilder sb = new StringBuilder();
        sb.append(getRootFolder() + "\n");
        sb.append(getBasePackage() + "\n");
        sb.append(getModulePackage() + "\n");
        sb.append(getDAOPackage() + "\n");
        sb.append(getServicePackage() + "\n");
        sb.append(getServiceImplPackage() + "\n");
        sb.append(getModelPackage() + "\n");
        sb.append(getFormWebPackage() + "\n");
        // sb.append(getIbatisPackage() + "\n");
        // sb.append(getIbatisSQLPackage() + "\n");
        return sb.toString();
    }

    public String printTreeFolder() {
        StringBuilder sb = new StringBuilder();
        sb.append(getRootFolder() + "\n");
        sb.append(getBaseFolder() + "\n");
        sb.append(getModuleFolder() + "\n");
        sb.append(getDAOFolder() + "\n");
        sb.append(getServiceFolder() + "\n");
        sb.append(getServiceImplFolder() + "\n");
        sb.append(getModelFolder() + "\n");
        sb.append(getFormWebFolder() + "\n");
        // sb.append(getIbatisFolder() + "\n");
        // sb.append(getIbatisSQLFolder() + "\n");
        // sb.append(getIbatisTestFolder() + "\n");
        return sb.toString();
    }
}
