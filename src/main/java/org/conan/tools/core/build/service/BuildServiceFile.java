package org.conan.tools.core.build.service;

import java.util.HashMap;
import java.util.Map;

import org.conan.tools.core.factory.VelocityFactory;
import org.conan.tools.core.file.ClazzTree;
import org.conan.tools.core.file.PackageTree;
import org.conan.tools.core.model.CopyRightObject;
import org.conan.tools.core.model.ServicePO;
import org.conan.tools.util.io.WriteFile;
import org.conan.tools.util.match.DateMatch;

/**
 * 
 * @author Conan
 */
public class BuildServiceFile {

    public BuildServiceFile(ServicePO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), pack);

        Map<String, String> map = new HashMap<String, String>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRightObject.AUTHOR);
        map.put("copyright", CopyRightObject.COPYRIGHT);

        map.put("model", po.getModel());
        map.put("import_model", clazz.getModelPackageClazz());
        map.put("service_package", pack.getServicePackage());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.SERVICE_VM, map);
        new WriteFile(clazz.getServiceFile(), vf.getWriter());
    }
}
