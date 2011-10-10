/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.model;

/**
 * 
 * @author conan
 */
public class PackagePO extends FilePO {

    protected String module;
    protected String basePackage;

    public PackagePO() {
    }

    public PackagePO(String root, String basePackage, String module) {
        super(root);
        this.module = module;
        this.basePackage = basePackage;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

}
