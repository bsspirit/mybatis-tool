/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.model;

/**
 *
 * @author conan
 */
public class ClazzPO extends PackagePO {

    public ClazzPO() {
    }

    public ClazzPO(String root, String basePackage, String module, String model) {
        super(root, basePackage, module);
        this.model = model;
    }
    String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
