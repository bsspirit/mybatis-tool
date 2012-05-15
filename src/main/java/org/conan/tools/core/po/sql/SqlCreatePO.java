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
import org.conan.tools.core.parser.IndexBean;
import org.conan.tools.core.parser.PropertyBean;
import org.conan.tools.core.parser.SqlBean;
import org.conan.tools.core.parser.TableBean;
import org.conan.tools.core.po.file.FilePO;
import org.conan.tools.core.xmlloader.IndexType;
import org.conan.tools.core.xmlloader.ModelType;
import org.conan.tools.core.xmlloader.ModuleType;
import org.conan.tools.core.xmlloader.PropType;
import org.conan.tools.util.io.WriteFile;

/**
 * 
 * @author conan
 */
public class SqlCreatePO extends FilePO {
    
    private String dbname;
    private List<ModuleType> modules;
    
    public SqlCreatePO(String root, String dbname, List<ModuleType> modules) {
        super(root);
        this.dbname = dbname;
        this.modules = modules;
    }
    
    public SqlCreatePO() {
    }
    
    public String getDbname() {
        return dbname;
    }
    
    public List<TableBean> getTables() {
        List<TableBean> tables = new ArrayList<TableBean>();
        for (ModuleType module : this.modules) {
            for (ModelType model : module.getModel()) {
                TableBean tb = new TableBean(model.getTable());
                for (PropType prop : model.getProp()) {
                    tb.getPbs().add(new PropertyBean(prop.getName(), prop.getType(), prop.isNull(), prop.isUnique(), prop.getDefault()));
                }
                
                for (IndexType idx : model.getIndex()) {
                    tb.getIbs().add(new IndexBean(idx.getType(), idx.getName()));
                }
                
                tables.add(tb);
            }
        }
        return tables;
    }
    
    public List<String> getTablesName() {
        List<String> list = new ArrayList<String>();
        for (TableBean table : getTables()) {
            list.add(table.getTable());
        }
        return list;
    }
    
    @Override
    public void create() {
        ResourceTree res = new ResourceTree(this.root);
        SqlBean sb = new SqlBean(getTables());
        
        Map<String, Object> map = this.getVMMap();
        map.put("dbname", this.getDbname());
        map.put("tables", sb.getSqlCreateTables());
        
        VelocityFactory vf = new VelocityFactory(VelocityFactory.SQL_CREATE_VM, map);
        new WriteFile(res.getSQLCreateFile(), vf.getWriter());
    }
    
}
