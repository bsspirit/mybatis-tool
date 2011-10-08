package org.conan.tools.core.file;

import java.io.File;

import org.conan.tools.util.match.StringMatch;

/**
 * 
 * @author Conan
 */
public class ClazzTree {

    public ClazzTree(String model, PackageTree pack) {
        this.pack = pack;
        this.model = model;
    }

    public static final String DAO = "DAO";
    public static final String DAO_IBATIS = "DAOIbatis";
    public static final String DAO_IBATIS_TEST = "DAOIbatisTest";
    public static final String SERVICE = "Service";
    public static final String SERVICE_IMPL = "ServiceImpl";

    public static final String DTO = "DTO";
    public static final String FORM = "Form";
    public static final String MODULE_DTO = "ModuleDTO";
    public static final String XML_FILE = ".xml";
    public static final String JAVA_FILE = ".java";
    public static final String SQL_FILE = ".sql";
    private PackageTree pack;
    private String model;

    public String getDAOFile() {
        return pack.getDAOFolder() + File.separator + getDAOClazz();
    }

    @Deprecated
    public String getIbatisFile() {
        return pack.getIbatisFolder() + File.separator + getIbatisClazz();
    }

    @Deprecated
    public String getIbatisTestFile() {
        return pack.getIbatisTestFolder() + File.separator + getIbatisTestClazz();
    }

    public String getIbatisSQLFile() {
        return pack.getDAOFolder() + File.separator + getIbatisSQLClazz();
    }

    public String getServiceFile() {
        return pack.getServiceFolder() + File.separator + getServiceClazz();
    }

    public String getServiceImplFile() {
        return pack.getServiceImplFolder() + File.separator + getServiceImplClazz();
    }

    public String getSQLCreateFile() {
        return pack.getSQLFolder() + File.separator + getSQLCreateClazz();
    }

    public String getSQLDropFile() {
        return pack.getSQLFolder() + File.separator + getSQLDropClazz();
    }

    public String getModelFile() {
        return pack.getModelFolder() + File.separator + getModelClazz();
    }

    public String getModelModuleFile() {
        return pack.getModelFolder() + File.separator + getModelModuleClazz();
    }

    public String getWebFormFile() {
        return pack.getFormWebFolder() + File.separator + getWebFormClazz();
    }

    public String getDAOPackageClazz() {
        return pack.getDAOPackage() + PackageTree.POINT + getModel() + DAO;
    }

    public String getServicePackageClazz() {
        return pack.getServicePackage() + PackageTree.POINT + getModel() + SERVICE;
    }

    public String getIbatisPackageClazz() {
        return pack.getIbatisPackage() + PackageTree.POINT + getModel() + DAO_IBATIS;
    }

    public String getModelPackageClazz() {
        return pack.getModelPackage() + PackageTree.POINT + getModel() + DTO;
    }

    public String getDAOClazz() {
        return getModel() + DAO + JAVA_FILE;
    }

    @Deprecated
    public String getIbatisClazz() {
        return getModel() + DAO_IBATIS + JAVA_FILE;
    }

    @Deprecated
    public String getIbatisTestClazz() {
        return getModel() + DAO_IBATIS_TEST + JAVA_FILE;
    }

    public String getServiceClazz() {
        return getModel() + SERVICE + JAVA_FILE;
    }

    public String getServiceImplClazz() {
        return getModel() + SERVICE_IMPL + JAVA_FILE;
    }

    public String getWebFormClazz() {
        return getModel() + FORM + JAVA_FILE;
    }

    public String getIbatisSQLClazz() {
        return getModelLowercase() + XML_FILE;
    }

    public String getModelClazz() {
        return getModel() + DTO + JAVA_FILE;
    }

    public String getModelModuleClazz() {
        return StringMatch.first2Uppercase(model) + MODULE_DTO + JAVA_FILE;
    }

    public String getSQLCreateClazz() {
        return "create" + SQL_FILE;
    }

    public String getSQLDropClazz() {
        return "drop" + SQL_FILE;
    }

    public String getModel() {
        return model;
    }

    public String getModelLowercase() {
        return StringMatch.first2Lowercase(model);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String[] getTreeFileArray() {
        String[] tree = new String[8];
        tree[0] = getDAOFile();
        tree[1] = getIbatisSQLFile();
        tree[2] = getModelFile();
        tree[3] = getWebFormFile();
        tree[4] = getServiceFile();
        tree[5] = getServiceImplFile();
        tree[6] = getSQLCreateFile();
        tree[7] = getSQLDropFile();
        // tree[1] = getIbatisFile();
        // tree[4] = getIbatisTestFile();
        return tree;
    }

    public String printTreeClazz() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDAOClazz() + "\n");
        sb.append(getIbatisSQLClazz() + "\n");
        sb.append(getModelClazz() + "\n");
        sb.append(getServiceClazz() + "\n");
        sb.append(getServiceImplClazz() + "\n");
        sb.append(getWebFormClazz() + "\n");
        // sb.append(getIbatisClazz() + "\n");
        // sb.append(getIbatisTestClazz() + "\n");
        return sb.toString();
    }

    public String printTreeFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDAOFile() + "\n");
        sb.append(getServiceFile() + "\n");
        sb.append(getIbatisSQLFile() + "\n");
        sb.append(getModelFile() + "\n");
        sb.append(getServiceFile() + "\n");
        sb.append(getServiceImplFile() + "\n");
        sb.append(getWebFormFile() + "\n");
        sb.append(getSQLCreateFile() + "\n");
        sb.append(getSQLDropFile() + "\n");

        // sb.append(getIbatisFile() + "\n");
        // sb.append(getIbatisTestFile() + "\n");
        return sb.toString();
    }
}
