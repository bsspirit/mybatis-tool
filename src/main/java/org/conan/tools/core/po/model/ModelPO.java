/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.po.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.conan.tools.core.build.VelocityFactory;
import org.conan.tools.core.build.tree.ClazzTree;
import org.conan.tools.core.parser.ModelClazzBean;
import org.conan.tools.core.parser.PropertyBean;
import org.conan.tools.core.po.file.ClazzPO;
import org.conan.tools.core.xmlloader.ModelType;
import org.conan.tools.core.xmlloader.ModuleType;
import org.conan.tools.core.xmlloader.PropType;
import org.conan.tools.util.io.WriteFile;
import org.conan.tools.util.match.JavaSQLMatch;

/**
 * 
 * @author conan
 */
public class ModelPO extends ClazzPO {

    protected List<PropertyBean> property = new ArrayList<PropertyBean>(10);
    private List<String> imports = new ArrayList<String>(10);

    public ModelPO() {
    }

    public ModelPO(String root, String basePackage, List<ModuleType> modules) {
        super(root, basePackage, modules);
    }

    @Override
    public void create() {
        for (ModuleType module : getModuleTypes()) {
            for (ModelType model : module.getModel()) {
                for (PropType prop : model.getProp()) {
                    this.property.add(new PropertyBean(prop.getName(), prop.getType()));
                    if (JavaSQLMatch.isJavaImport(prop.getType())) {
                        this.imports.add(JavaSQLMatch.sql2JAVA(prop.getType()));
                    }
                }
                write(module, model);
            }
        }
    }

    protected void write(ModuleType module, ModelType model) {
        ClazzTree clazz = new ClazzTree(this.root, this.basePackage, module.getName(), model.getName());
        ModelClazzBean mcb = new ModelClazzBean(clazz.getModel(), this.property);

        Map<String, Object> map = this.getVMMap();
        map.put("model", clazz.getModel());
        map.put("model_package", clazz.getModelPackage());
        map.put("model_imports", this.imports);
        map.put("model_constructorMethods", mcb.getConstructorMethod());
        map.put("model_properties", mcb.getProperties());
        map.put("model_setMethods", mcb.getSetMethod());
        map.put("model_getMethods", mcb.getGetMethod());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.MODEL_VM, map);
        new WriteFile(clazz.getModelFile(), vf.getWriter());
    }

}
