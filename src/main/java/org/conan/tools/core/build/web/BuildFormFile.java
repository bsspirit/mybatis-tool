package org.conan.tools.core.build.web;

import java.util.HashMap;
import java.util.Map;

import org.conan.tools.core.build.ClazzTree;
import org.conan.tools.core.build.PackageTree;
import org.conan.tools.core.clazz.ModelClazzBean;
import org.conan.tools.core.factory.VelocityFactory;
import org.conan.tools.core.model.CopyRightObject;
import org.conan.tools.core.model.FormPO;
import org.conan.tools.util.io.WriteFile;
import org.conan.tools.util.match.DateMatch;
import org.conan.tools.util.match.StringMatch;

/**
 *
 * @author Conan
 */
public class BuildFormFile {

    public BuildFormFile(FormPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), pack);
        ModelClazzBean mcb = new ModelClazzBean(po);

        Map<String, String> map = new HashMap<String, String>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRightObject.AUTHOR);
        map.put("copyright", CopyRightObject.COPYRIGHT);

        map.put("model", po.getModel());
        map.put("model_1", StringMatch.first2Lowercase(po.getModel()));
        map.put("form_package", pack.getFormWebPackage());
        map.put("import_model", clazz.getModelPackageClazz());
        map.put("model_constructorMethods", mcb.getConstructorMethod());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.FORM_MODEL_VM, map);
        new WriteFile(clazz.getWebFormFile(), vf.getWriter());
    }
}
