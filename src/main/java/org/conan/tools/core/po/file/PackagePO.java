/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.po.file;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.conan.tools.core.build.tree.PackageTree;
import org.conan.tools.core.xmlloader.ModuleType;
import org.conan.tools.util.match.DateMatch;
import org.conan.tools.util.match.RandomUtil;

/**
 * 
 * @author conan
 */
public class PackagePO extends FilePO {

    protected List<ModuleType> modules;
    protected String basePackage;

    public PackagePO() {
    }

    public PackagePO(String root, String basePackage, List<ModuleType> modules) {
        super(root);
        this.basePackage = basePackage;
        this.modules = modules;

    }

    public List<ModuleType> getModuleTypes() {
        return modules;
    }

    public List<String> getModules() {
        List<String> list = new ArrayList<String>();
        for (ModuleType m : modules) {
            list.add(m.getName());
        }
        return list;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    @Override
    public void create() {
        for (ModuleType module : this.modules) {
            PackageTree pack = new PackageTree(this.root, this.basePackage, module.getName());
            List<String> trees = pack.getTreeFile();
            for (String tree : trees) {
                new File(tree).mkdirs();
            }
            System.out.println(pack.printTreeFile());
        }
    }

    protected Map<String, Object> getVMMap() {
        Map<String, Object> map = super.getVMMap();
        map.put("base", this.basePackage);
        return map;
    }

}
