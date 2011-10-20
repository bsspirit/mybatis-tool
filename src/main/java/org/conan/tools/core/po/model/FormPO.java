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
import org.conan.tools.core.xmlloader.ModelType;
import org.conan.tools.core.xmlloader.ModuleType;
import org.conan.tools.core.xmlloader.PropType;
import org.conan.tools.util.io.WriteFile;

/**
 * 
 * @author conan
 */
public class FormPO extends ModelPO {

    public FormPO() {
    }

    public FormPO(String root, String basePackage, List<ModuleType> modules) {
        super(root, basePackage, modules);
    }

    @Override
    public void create() {
        for (ModuleType module : getModuleTypes()) {
            for (ModelType model : module.getModel()) {
                List<PropertyBean> property = new ArrayList<PropertyBean>(10);
                for (PropType prop : model.getProp()) {
                    property.add(new PropertyBean(prop.getName(), prop.getType()));
                }
                write(module, model, property);
            }
        }
    }

    protected void write(ModuleType module, ModelType model, List<PropertyBean> property) {
        ClazzTree clazz = new ClazzTree(this.root, this.basePackage, module.getName(), model.getName());
        ModelClazzBean mcb = new ModelClazzBean(clazz.getModel(), property);

        Map<String, Object> map = this.getVMMap();
        map.put("model", clazz.getModel());
        map.put("model_1", clazz.getModelLowercase());
        map.put("form_package", clazz.getFormWebPackage());
        map.put("import_model", clazz.getModelPackageClazz());
        map.put("model_constructorMethods", mcb.getConstructorMethod());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.FORM_MODEL_VM, map);
        new WriteFile(clazz.getWebFormFile(), vf.getWriter());
    }

}
