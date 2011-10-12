/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.parser;

import java.util.ArrayList;
import java.util.List;

import org.conan.tools.core.po.model.FormPO;
import org.conan.tools.core.po.model.ModelPO;
import org.conan.tools.core.po.model.ModuleModelPO;

/**
 * 
 * @author Conan
 */
public class ModelClazzBean {

    // public ModelClazzBean(ModuleModelPO po) {
    // List<PropertyBean> propertiesBean = po.getProperty();
    // setProperties(propertiesBean);
    //
    // MethodBean mb = new MethodBean(po.getModuleModel(), po.getProperty());
    // this.getMethod = mb.getGetMethod();
    // this.setMethod = mb.getSetMethod();
    // this.constructorMethod = mb.getConstructorMethod();
    // }

    public ModelClazzBean(String model, List<PropertyBean> propertiesBean) {
        setProperties(propertiesBean);
        setMethod(model, propertiesBean);
    }

    private List<String> properties = new ArrayList<String>(10);
    private String setMethod;
    private String getMethod;
    private String constructorMethod;

    public void setProperties(List<PropertyBean> propertiesBean) {
        for (PropertyBean pb : propertiesBean) {
            properties.add(pb.getTypeName());
        }
    }

    public void setMethod(String model, List<PropertyBean> propertiesBean) {
        MethodBean mb = new MethodBean(model, propertiesBean);
        this.getMethod = mb.getGetMethod();
        this.setMethod = mb.getSetMethod();
        this.constructorMethod = mb.getConstructorMethod();
    }

    public List<String> getProperties() {
        return this.properties;
    }

    public String getSetMethod() {
        return this.setMethod;
    }

    public String getGetMethod() {
        return this.getMethod;
    }

    public String getConstructorMethod() {
        return this.constructorMethod;
    }
}
