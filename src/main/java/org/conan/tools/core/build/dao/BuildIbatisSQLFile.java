package org.conan.tools.core.build.dao;

import java.util.HashMap;
import java.util.Map;

import org.conan.tools.core.build.ClazzTree;
import org.conan.tools.core.build.PackageTree;
import org.conan.tools.core.clazz.SqlMapBean;
import org.conan.tools.core.factory.VelocityFactory;
import org.conan.tools.core.model.CopyRightObject;
import org.conan.tools.core.model.SqlPO;
import org.conan.tools.util.io.WriteFile;
import org.conan.tools.util.match.DateMatch;
import org.conan.tools.util.match.StringMatch;

/**
 *
 * @author Conan
 */
public class BuildIbatisSQLFile {

    public BuildIbatisSQLFile(SqlPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), pack);

        SqlMapBean smb = new SqlMapBean(po.getProperty(),po.getFinder());

        Map map = new HashMap();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRightObject.AUTHOR);
        map.put("copyright", CopyRightObject.COPYRIGHT);

        map.put("model", po.getModel());
        map.put("model_1", StringMatch.first2Lowercase(po.getModel()));
        map.put("table", po.getTable());
        map.put("import_dao", pack.getDAOPackage());
        map.put("import_model", pack.getModelPackage());
        map.put("sql_result_maps", smb.getSqlResultMaps());
        map.put("sql_conditions", smb.getSqlConditions());
        map.put("sql_selects", smb.getSqlSelects());
        map.put("sql_updates", smb.getSqlUpdates());
        map.put("sql_inserts_value", smb.getSqlInsertsValue());
        map.put("sql_inserts_name", smb.getSqlInsertsName());
        map.put("sql_delete_mark", po.isMark());
        map.put("sql_finders", smb.getSqlFinders());


        VelocityFactory vf = new VelocityFactory(VelocityFactory.IBATIS_SQL_VM, map);
        new WriteFile(clazz.getIbatisSQLFile(), vf.getWriter());
    }
}
