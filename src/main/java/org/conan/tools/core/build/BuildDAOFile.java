package org.conan.tools.core.build;

import java.util.HashMap;
import java.util.Map;

import org.conan.tools.core.factory.VelocityFactory;
import org.conan.tools.core.file.ClazzTree;
import org.conan.tools.core.file.PackageTree;
import org.conan.tools.core.io.WriteFile;
import org.conan.tools.core.model.CopyRightObject;
import org.conan.tools.core.model.DaoPO;
import org.conan.tools.util.match.DateMatch;

/**
 * 
 * @author Conan
 */
public class BuildDAOFile {

    public BuildDAOFile(DaoPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), pack);

        Map<String, String> map = new HashMap<String, String>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRightObject.AUTHOR);
        map.put("copyright", CopyRightObject.COPYRIGHT);
        map.put("base", po.getBasePackage());

        map.put("model", po.getModel());
        map.put("import_model", clazz.getModelPackageClazz());
        map.put("dao_package", pack.getDAOPackage());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.DAO_VM, map);
        new WriteFile(clazz.getDAOFile(), vf.getWriter());
    }
}
