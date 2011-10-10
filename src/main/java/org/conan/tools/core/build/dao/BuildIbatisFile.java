package org.conan.tools.core.build.dao;

import java.util.HashMap;
import java.util.Map;

import org.conan.tools.core.build.ClazzTree;
import org.conan.tools.core.build.PackageTree;
import org.conan.tools.core.factory.VelocityFactory;
import org.conan.tools.core.model.CopyRightObject;
import org.conan.tools.core.model.IbatisPO;
import org.conan.tools.util.io.WriteFile;
import org.conan.tools.util.match.DateMatch;
import org.conan.tools.util.match.StringMatch;

/**
 * 
 * @author Conan
 */
@Deprecated
public class BuildIbatisFile {

    public BuildIbatisFile(IbatisPO po) {
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
        map.put("dao_ibatis_package", pack.getIbatisPackage());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.IBATIS_VM, map);
        new WriteFile(clazz.getIbatisFile(), vf.getWriter());
    }
}
