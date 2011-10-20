package org.conan.tools.core.build.tree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.conan.tools.util.match.StringMatch;

/**
 * 
 * @author Conan
 */
public class ClazzTree extends PackageTree {

    protected String model;

    public ClazzTree(String root, String basePackage, String module, String model) {
        super(root, basePackage, module);
        this.model = model;
    }

    public String getModel() {
        return StringMatch.first2Uppercase(model);
    }

    public String getDAOFile() {
        return getDAOFolder() + File.separator + getDAOClazz();
    }

    @Deprecated
    public String getIbatisFile() {
        return getIbatisFolder() + File.separator + getIbatisClazz();
    }

    @Deprecated
    public String getIbatisTestFile() {
        return getIbatisTestFolder() + File.separator + getIbatisTestClazz();
    }

    public String getIbatisSQLFile() {
        return getDAOFolder() + File.separator + getIbatisSQLClazz();
    }

    public String getServiceFile() {
        return getServiceFolder() + File.separator + getServiceClazz();
    }

    public String getServiceImplFile() {
        return getServiceImplFolder() + File.separator + getServiceImplClazz();
    }

    public String getServiceImplTestFile() {
        return getServiceTestFolder() + File.separator + getServiceImplTestClazz();
    }

    public String getModelFile() {
        return getModelFolder() + File.separator + getModelClazz();
    }

    public String getModelModuleFile() {
        return getModelFolder() + File.separator + getModelModuleClazz();
    }

    public String getWebFormFile() {
        return getFormWebFolder() + File.separator + getWebFormClazz();
    }

    public String getDAOPackageClazz() {
        return getDAOPackage() + PackageTree.POINT + getModel() + DAO_I;
    }

    public String getServicePackageClazz() {
        return getServicePackage() + PackageTree.POINT + getModel() + SERVICE_I;
    }

    @Deprecated
    public String getIbatisPackageClazz() {
        return getIbatisPackage() + PackageTree.POINT + getModel() + DAO_IBATIS;
    }

    public String getModelPackageClazz() {
        return getModelPackage() + PackageTree.POINT + getModel() + DTO;
    }

    public String getDAOClazz() {
        return getModel() + DAO_I + JAVA_FILE;
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
        return getModel() + SERVICE_I + JAVA_FILE;
    }

    public String getServiceImplClazz() {
        return getModel() + SERVICE_IMPL + JAVA_FILE;
    }

    public String getServiceImplTestClazz() {
        return getModel() + SERVICE_IMPL_TEST + JAVA_FILE;
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
        return getModel() + MODULE_DTO + JAVA_FILE;
    }

    public String getModelLowercase() {
        return StringMatch.first2Lowercase(model);
    }

    public List<String> getTreeFile() {
        List<String> tree = new ArrayList<String>();
        tree.add(getDAOFile());
        tree.add(getIbatisSQLFile());
        tree.add(getModelFile());
        tree.add(getWebFormFile());
        tree.add(getServiceFile());
        tree.add(getServiceImplFile());
        tree.add(getServiceImplTestFile());
        // tree.add(getIbatisFile());
        // tree.add(getIbatisTestFile());
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
        sb.append(getServiceImplTestClazz() + "\n");
        // sb.append(getIbatisClazz() + "\n");
        // sb.append(getIbatisTestClazz() + "\n");
        return sb.toString();
    }
}
