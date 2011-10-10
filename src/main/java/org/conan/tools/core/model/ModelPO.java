/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.model;

import java.util.ArrayList;
import java.util.List;
import org.conan.tools.core.clazz.PropertyBean;

/**
 *
 * @author conan
 */
public class ModelPO extends ClazzPO {

    List<PropertyBean> property = new ArrayList<PropertyBean>(10);
    List<String> imports = new ArrayList<String>(10);

    public ModelPO(){}
    public ModelPO(String root, String basePackage, String module, String model) {
        super(root, basePackage, module, model);
    }
    
    public List<PropertyBean> getProperty() {
        return property;
    }

    public List<String> getImports() {
        return imports;
    }
}
