package org.conan.tools.core.build;

import java.util.HashMap;
import java.util.Map;
import org.conan.tools.core.file.ClazzTree;
import org.conan.tools.core.file.PackageTree;
import org.conan.tools.core.factory.VelocityFactory;
import org.conan.tools.util.match.DateMatch;
import org.conan.tools.core.io.OutputFile;
import org.conan.tools.core.model.CopyRightObject;
import org.conan.tools.core.model.TestPO;
import org.conan.tools.util.match.StringMatch;

/**
 *
 * @author Conan
 */
public class BuildIbatisTestFile {

    public BuildIbatisTestFile(TestPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), pack);

        Map map = new HashMap();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRightObject.AUTHOR);
        map.put("copyright", CopyRightObject.COPYRIGHT);

        map.put("model", po.getModel());
        map.put("model_1", StringMatch.first2Lowercase(po.getModel()));
        map.put("import_model", clazz.getModelPackageClazz());
        map.put("import_dao", clazz.getDAOPackageClazz());
        map.put("dao_ibatis_package", pack.getIbatisPackage());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.IBATIS_TEST_VM, map);
        new OutputFile(clazz.getIbatisTestFile(), vf.getWriter());
    }
}
