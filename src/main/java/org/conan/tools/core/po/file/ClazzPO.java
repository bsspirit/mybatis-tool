/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.po.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.conan.tools.core.build.tree.ClazzTree;
import org.conan.tools.core.xmlloader.ModelType;
import org.conan.tools.core.xmlloader.ModuleType;

/**
 * 
 * @author conan
 */
public class ClazzPO extends PackagePO {

    public ClazzPO() {
    }

    public ClazzPO(String root, String basePackage, List<ModuleType> modules) {
        super(root, basePackage, modules);
    }

    @Override
    public void create() {
        for (ModuleType module : getModuleTypes()) {
            for (ModelType model : module.getModel()) {
                ClazzTree pack = new ClazzTree(this.root, this.basePackage, module.getName(), model.getName());
                List<String> trees = pack.getTreeFile();
                for (String tree : trees) {
                    try {
                        new File(tree).createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(pack.printTreeFile());
            }
        }
    }

}
