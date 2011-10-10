package org.conan.tools.core.build.service;

import java.util.HashMap;
import java.util.Map;

import org.conan.tools.core.build.ClazzTree;
import org.conan.tools.core.build.PackageTree;
import org.conan.tools.core.factory.VelocityFactory;
import org.conan.tools.core.model.CopyRightObject;
import org.conan.tools.core.model.ServiceImplPO;
import org.conan.tools.util.io.WriteFile;
import org.conan.tools.util.match.DateMatch;
import org.conan.tools.util.match.StringMatch;

/**
 * 
 * @author Conan
 */
public class BuildServiceImplFile {

    public BuildServiceImplFile(ServiceImplPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), pack);

        Map<String, String> map = new HashMap<String, String>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRightObject.AUTHOR);
        map.put("copyright", CopyRightObject.COPYRIGHT);

        map.put("model", po.getModel());
        map.put("model_1", StringMatch.first2Lowercase(po.getModel()));
        map.put("import_model", clazz.getModelPackageClazz());
        map.put("import_dao", clazz.getDAOPackageClazz());
        map.put("import_service", clazz.getServicePackageClazz());
        map.put("service_impl_package", pack.getServiceImplPackage());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.SERVICE_IMPL_VM, map);
        new WriteFile(clazz.getServiceImplFile(), vf.getWriter());
    }
}
