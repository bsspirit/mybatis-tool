/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.po.model;

import java.util.ArrayList;
import java.util.List;

import org.conan.tools.core.parser.PropertyBean;
import org.conan.tools.core.po.file.PackagePO;
import org.conan.tools.util.match.StringMatch;

/**
 *
 * @author conan
 */
public class ModuleModelPO extends PackagePO {

    private List<PropertyBean> property = new ArrayList<PropertyBean>(10);

    public ModuleModelPO(String root, String basePackage, String module) {
        super(root, basePackage, module);
    }

    public ModuleModelPO() {
    }

    public List<PropertyBean> getProperty() {
        return property;
    }

    public String getModuleModel(){
        return StringMatch.first2Uppercase(this.module) +"Module";
    }
}
