/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.po.sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.conan.tools.core.build.VelocityFactory;
import org.conan.tools.core.build.tree.ResourceTree;
import org.conan.tools.core.po.file.FilePO;
import org.conan.tools.core.xmlloader.ModelType;
import org.conan.tools.core.xmlloader.ModuleType;
import org.conan.tools.util.io.WriteFile;

/**
 * 
 * @author conan
 */
public class SqlDropPO extends FilePO {

    private String dbname;
    private List<ModuleType> modules;

    public SqlDropPO(String root, String dbname, List<ModuleType> modules) {
        super(root);
        this.dbname = dbname;
        this.modules = modules;
    }

    public SqlDropPO() {
    }

    public String getDbname() {
        return dbname;
    }

    public List<String> getTables() {
        List<String> tables = new ArrayList<String>();
        for (ModuleType module : this.modules) {
            for (ModelType model : module.getModel()) {
                tables.add(model.getTable());
            }
        }
        return tables;
    }

    @Override
    public void create() {
        ResourceTree res = new ResourceTree(this.root);

        Map<String, Object> map = this.getVMMap();
        map.put("dbname", this.getDbname());
        map.put("tables", getTables());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.SQL_DROP_VM, map);
        new WriteFile(res.getSQLDropFile(), vf.getWriter());
    }

}
