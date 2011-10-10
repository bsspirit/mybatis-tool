package org.conan.tools.core.build.config;

import java.util.HashMap;
import java.util.Map;

import org.conan.tools.core.build.PackageTree;
import org.conan.tools.core.build.ResourceTree;
import org.conan.tools.core.factory.VelocityFactory;
import org.conan.tools.core.model.CopyRightObject;
import org.conan.tools.core.model.SqlCreatePO;
import org.conan.tools.util.io.WriteFile;
import org.conan.tools.util.match.DateMatch;

/**
 * 
 * @author Conan
 */
public class BuildSQLCreateFile {

    public BuildSQLCreateFile(SqlCreatePO po) {
        PackageTree pack = new PackageTree(po);
        ResourceTree res = new ResourceTree(po.getModel(), pack);

        Map<String, String> map = new HashMap<String, String>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRightObject.AUTHOR);
        map.put("copyright", CopyRightObject.COPYRIGHT);

        map.put("model", po.getModel());
        // map.put("import_model", clazz.getModelPackageClazz());
        // map.put("dao_package", pack.getDAOPackage());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.SQL_CREATE_VM, map);
        new WriteFile(res.getSQLCreateFile(), vf.getWriter());
    }
}
