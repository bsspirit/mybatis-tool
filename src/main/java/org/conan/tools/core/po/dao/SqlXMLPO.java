/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.po.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.conan.tools.core.build.VelocityFactory;
import org.conan.tools.core.build.tree.ClazzTree;
import org.conan.tools.core.parser.PropertyBean;
import org.conan.tools.core.parser.SqlFinderBean;
import org.conan.tools.core.parser.SqlMapBean;
import org.conan.tools.core.po.file.ClazzPO;
import org.conan.tools.core.xmlloader.ModelType;
import org.conan.tools.core.xmlloader.ModuleType;
import org.conan.tools.core.xmlloader.PropType;
import org.conan.tools.util.io.WriteFile;

/**
 * 
 * @author conan
 */
public class SqlXMLPO extends ClazzPO {

    private boolean mark;// 标记删除
    private List<SqlFinderBean> finder = new ArrayList<SqlFinderBean>();
    protected List<PropertyBean> property = new ArrayList<PropertyBean>();

    public SqlXMLPO() {
    }

    public SqlXMLPO(String root, String basePackage, List<ModuleType> modules) {
        super(root, basePackage, modules);
    }

    @Override
    public void create() {
        for (ModuleType module : getModuleTypes()) {
            for (ModelType model : module.getModel()) {
                for (PropType prop : model.getProp()) {
                    this.property.add(new PropertyBean(prop.getName(), prop.getType(), prop.isNull()));
                }
                write(module, model);
                this.property.clear();
            }
        }
    }

    void write(ModuleType module, ModelType model) {
        ClazzTree clazz = new ClazzTree(this.root, this.basePackage, module.getName(), model.getName());
        SqlMapBean smb = new SqlMapBean(this.property, this.finder);

        Map<String, Object> map = this.getVMMap();
        map.put("model", clazz.getModel());
        map.put("model_1", clazz.getModelLowercase());
        map.put("table", model.getTable());
        map.put("import_dao", clazz.getDAOPackage());
        map.put("import_model", clazz.getModelPackage());
        map.put("sql_result_maps", smb.getSqlResultMaps());
        map.put("sql_conditions", smb.getSqlConditions());
        map.put("sql_selects", smb.getSqlSelects());
        map.put("sql_updates", smb.getSqlUpdates());
        map.put("sql_inserts_value", smb.getSqlInsertsValue());
        map.put("sql_inserts_name", smb.getSqlInsertsName());
        map.put("sql_delete_mark", this.mark);
        map.put("sql_finders", smb.getSqlFinders());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.IBATIS_SQL_VM, map);
        new WriteFile(clazz.getIbatisSQLFile(), vf.getWriter());
    }

}
