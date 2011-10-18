package org.conan.tools.core.parser;

import java.util.ArrayList;
import java.util.List;

import org.conan.tools.core.po.config.MybatisXMLPO;
import org.conan.tools.core.po.config.SpringDaoXMLPO;
import org.conan.tools.core.po.config.SpringServiceXMLPO;
import org.conan.tools.core.po.dao.DaoPO;
import org.conan.tools.core.po.dao.IbatisPO;
import org.conan.tools.core.po.dao.SqlXMLPO;
import org.conan.tools.core.po.file.ClazzPO;
import org.conan.tools.core.po.file.FilePO;
import org.conan.tools.core.po.file.FolderPO;
import org.conan.tools.core.po.file.PackagePO;
import org.conan.tools.core.po.file.ResourcePO;
import org.conan.tools.core.po.model.FormPO;
import org.conan.tools.core.po.model.ModelPO;
import org.conan.tools.core.po.model.ModuleModelPO;
import org.conan.tools.core.po.service.ServiceImplPO;
import org.conan.tools.core.po.service.ServicePO;
import org.conan.tools.core.po.sql.SqlCreatePO;
import org.conan.tools.core.po.sql.SqlDropPO;
import org.conan.tools.core.po.test.IbatisTestPO;
import org.conan.tools.core.po.test.ServiceTestPO;
import org.conan.tools.core.xmlloader.DaoToolType;
import org.conan.tools.core.xmlloader.ModuleType;

/**
 * 
 * @author conan
 */
public class ParamObject {

    private String filePath;
    private String project;
    private String dbname;
    private List<ModuleType> modules = new ArrayList<ModuleType>();

    private List<ModuleModelPO> mmList = new ArrayList<ModuleModelPO>(20);
    private List<IbatisPO> ibatisList = new ArrayList<IbatisPO>(50);
    private List<IbatisTestPO> testList = new ArrayList<IbatisTestPO>(50);

    public ParamObject(DaoToolType obj) {
        filePath = obj.getFilePath();
        project = obj.getProject();
        dbname = obj.getDbname();
        modules.addAll(obj.getModules().getModule());

        // for (ModuleType moduleType : obj.getModules().getModule()) {
        //
        // String module = moduleType.getName();
        //
        // // // package
        // // packageList.add(new PackagePO(filePath, project, module));
        //
        // // moduleModel
        // ModuleModelPO mmpo = new ModuleModelPO(filePath, project, module);
        // mmList.add(mmpo);
        //
        // // spring service
        // ssPO.getModules().add(module);
        //
        // for (ModelType modelType : moduleType.getModel()) {
        //
        // String model = StringMatch.first2Uppercase(modelType.getName());
        // String table = modelType.getTable();
        //
        // // clazz
        // clazzList.add(new ClazzPO(filePath, project, module, model));
        //
        // // dao
        // daoList.add(new DaoPO(filePath, project, module, model));
        //
        // // serviceImpl
        // serviceList.add(new ServicePO(filePath, project, module, model));
        //
        // // serviceImpl test
        // serviceImplList.add(new ServiceImplPO(filePath, project, module,
        // model));
        //
        // // sql
        // TableBean tb = new TableBean(table);
        // sqlPO.tables.add(tb);
        //
        // // ibatisList.add(new IbatisPO(filePath, project, module,
        // // model));
        // // testList.add(new TestPO(filePath, project, module, model));
        //
        // // moduleModel
        // mmpo.getProperty().add(new
        // PropertyBean(StringMatch.first2Lowercase(model) + "DTO", model +
        // "DTO"));
        //
        // // model,sql,form
        // ModelPO mpo = new ModelPO(filePath, project, module, model);
        // modelList.add(mpo);
        // SqlXMLPO spo = new SqlXMLPO(filePath, project, module, model, table);
        // sqlList.add(spo);
        // FormPO fpo = new FormPO(filePath, project, module, model);
        // formList.add(fpo);
        //
        // for (PropType prop : modelType.getProp()) {
        // String propName = prop.getName();
        // String propType = prop.getType();
        // boolean propNull = prop.isNull();
        // boolean propUnique = prop.isUnique();
        // String propDefault = prop.getDefault();
        //
        // // model,sql
        // mpo.getProperty().add(new PropertyBean(propName, propType));
        // fpo.getProperty().add(new PropertyBean(propName, propType));
        // spo.getProperty().add(new PropertyBean(propName, propType,
        // propNull));
        // tb.getPbs().add(new PropertyBean(propName, propType, propNull,
        // propUnique, propDefault));
        //
        // // sql
        // if (propName.equals("mark")) {
        // spo.setMark(true);
        // }
        //
        // // model
        // if (JavaSQLMatch.isJavaImport(prop.getType())) {
        // mpo.getImports().add(JavaSQLMatch.sql2JAVA(prop.getType()));
        // }
        // }
        //
        // for (FinderType finder : modelType.getFinder()) {
        // String id = finder.getId();
        // String sql = finder.getSql();
        //
        // // sql
        // spo.getFinder().add(new
        // SqlFinderBean(StringMatch.first2Lowercase(model) + "." + id, sql));
        // }
        // }
        // }
    }

    public FilePO getFolderPO() {
        return new FolderPO(filePath);
    }

    public FilePO getResourcePO() {
        return new ResourcePO(filePath);
    }

    public PackagePO getPackagePO() {
        return new PackagePO(filePath, project, modules);
    }

    public ClazzPO getClazzPO() {
        return new ClazzPO(filePath, project, modules);
    }

    public SqlCreatePO getSqlCreatePO() {
        return new SqlCreatePO(filePath, dbname, modules);
    }
    
    public SqlDropPO getSqlDropPO() {
        return new SqlDropPO(filePath, dbname, modules);
    }
    
    public ServiceTestPO getServiceTestPO(){
        return new ServiceTestPO(filePath, project, modules);
    }

    public SpringServiceXMLPO getSpringServicePO() {
        return new SpringServiceXMLPO(filePath, project, modules);
    }

    public SpringDaoXMLPO getSpringDaoXMLPO() {
        return new SpringDaoXMLPO(filePath, project, modules);
    }
    
//    public MybatisXMLPO getMybatisXMLPO() {
//        return new MybatisXMLPO(filePath, project, modules);
//    }
    
    public ModelPO getModelPO() {
        return new ModelPO(filePath, project, modules);
    }

    public FormPO getFormPO() {
        return new FormPO(filePath, project, modules);
    }

    public DaoPO getDaoPO() {
        return new DaoPO(filePath, project, modules);
    }

    public SqlXMLPO getSqlXMLPO() {
        return new SqlXMLPO(filePath, project, modules);
    }

    public ServicePO getServicePO() {
        return new ServicePO(filePath, project, modules);
    }

    public ServiceImplPO getServiceImpl() {
        return new ServiceImplPO(filePath, project, modules);
    }

}
