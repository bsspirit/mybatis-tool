/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.build.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.conan.tools.core.clazz.ModelClazzBean;
import org.conan.tools.core.factory.VelocityFactory;
import org.conan.tools.core.file.ClazzTree;
import org.conan.tools.core.file.PackageTree;
import org.conan.tools.core.model.CopyRightObject;
import org.conan.tools.core.model.ModuleModelPO;
import org.conan.tools.util.io.WriteFile;
import org.conan.tools.util.match.DateMatch;

/**
 *
 * @author conan
 */
@Deprecated
public class BuildModuleModelFile {

    public BuildModuleModelFile(ModuleModelPO po) {

        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModule(), pack);
        ModelClazzBean mcb = new ModelClazzBean(po);

//        try {
//            CreateClazz.createClazz(clazz.getModelModuleFile());
//        } catch (IOException ex) {
//            Logger.getLogger(BuildModuleModelFile.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(clazz.getModelModuleFile());

        Map map = new HashMap();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRightObject.AUTHOR);
        map.put("copyright", CopyRightObject.COPYRIGHT);
        map.put("model", po.getModuleModel());
        map.put("model_package", pack.getModelPackage());
        map.put("model_constructorMethods", mcb.getConstructorMethod());
        map.put("model_properties", mcb.getProperties());
        map.put("model_setMethods", mcb.getSetMethod());
        map.put("model_getMethods", mcb.getGetMethod());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.MODEL_VM, map);
        new WriteFile(clazz.getModelModuleFile(), vf.getWriter());

    }
}
