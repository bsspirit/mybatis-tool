package org.conan.tools.core.build;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.conan.tools.core.build.tree.ClazzTree;
import org.conan.tools.core.build.tree.PackageTree;
import org.conan.tools.core.build.tree.ResourceTree;
import org.conan.tools.core.clazz.ModelClazzBean;
import org.conan.tools.core.clazz.SqlMapBean;
import org.conan.tools.core.model.CopyRight;
import org.conan.tools.core.model.DaoPO;
import org.conan.tools.core.model.FormPO;
import org.conan.tools.core.model.IbatisPO;
import org.conan.tools.core.model.ModelPO;
import org.conan.tools.core.model.ModuleModelPO;
import org.conan.tools.core.model.ParamObject;
import org.conan.tools.core.model.ServiceImplPO;
import org.conan.tools.core.model.ServicePO;
import org.conan.tools.core.model.SqlPO;
import org.conan.tools.core.model.SqlXMLPO;
import org.conan.tools.core.model.TestPO;
import org.conan.tools.util.io.WriteFile;
import org.conan.tools.util.match.DateMatch;
import org.conan.tools.util.match.StringMatch;

final public class BuildFactory {

    public static void buildALL(ParamObject po) {
        // buildSQLCreate(po.getSqlPO());// sql create
        buildSQLDrop(po.getSqlPO());// sql drop

        for (ModelPO model : po.getModelList()) {// model
            buildModel(model);
        }
        for (DaoPO dao : po.getDaoList()) {// dao
            buildDAO(dao);
        }
        for (SqlXMLPO sql : po.getSqlList()) {// sql
            buildIbatisSQL(sql);
        }
        for (ServicePO service : po.getServiceList()) {// service
            buildService(service);
        }
        for (ServiceImplPO serviceImpl : po.getServiceImplList()) {// service
            buildServiceImpl(serviceImpl);
        }
        for (FormPO form : po.getFormList()) {// web form
            buildForm(form);
        }
    }

    /**
     * sql create //TODO
     */
    public static void buildSQLCreate(SqlPO po) {
        ResourceTree res = new ResourceTree(po);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRight.AUTHOR);
        map.put("copyright", CopyRight.COPYRIGHT);

        // map.put("model", po.getModel());
        // map.put("import_model", clazz.getModelPackageClazz());
        // map.put("dao_package", pack.getDAOPackage());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.SQL_CREATE_VM, map);
        new WriteFile(res.getSQLCreateFile(), vf.getWriter());
    }

    /**
     * sql drop //TODO
     */
    public static void buildSQLDrop(SqlPO po) {
        ResourceTree res = new ResourceTree(po);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRight.AUTHOR);
        map.put("copyright", CopyRight.COPYRIGHT);

        map.put("dbname", po.getDbname());
        map.put("tables", po.getTables());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.SQL_DROP_VM, map);
        new WriteFile(res.getSQLDropFile(), vf.getWriter());
    }

    /**
     * model
     */
    public static void buildModel(ModelPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), po);
        ModelClazzBean mcb = new ModelClazzBean(po);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRight.AUTHOR);
        map.put("copyright", CopyRight.COPYRIGHT);
        map.put("timestamp", System.currentTimeMillis() + "" + new Random().nextInt(3) + "L");
        map.put("base", po.getBasePackage());

        map.put("model", po.getModel());
        map.put("model_package", pack.getModelPackage());
        map.put("model_imports", po.getImports());
        map.put("model_constructorMethods", mcb.getConstructorMethod());
        map.put("model_properties", mcb.getProperties());
        map.put("model_setMethods", mcb.getSetMethod());
        map.put("model_getMethods", mcb.getGetMethod());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.MODEL_VM, map);
        new WriteFile(clazz.getModelFile(), vf.getWriter());
    }

    /**
     * DAO file
     */
    public static void buildDAO(DaoPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), po);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRight.AUTHOR);
        map.put("copyright", CopyRight.COPYRIGHT);
        map.put("base", po.getBasePackage());

        map.put("model", po.getModel());
        map.put("import_model", clazz.getModelPackageClazz());
        map.put("dao_package", pack.getDAOPackage());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.DAO_VM, map);
        new WriteFile(clazz.getDAOFile(), vf.getWriter());
    }

    /**
     * service
     */
    public static void buildService(ServicePO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), po);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRight.AUTHOR);
        map.put("copyright", CopyRight.COPYRIGHT);
        map.put("base", po.getBasePackage());

        map.put("model", po.getModel());
        map.put("import_model", clazz.getModelPackageClazz());
        map.put("service_package", pack.getServicePackage());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.SERVICE_VM, map);
        new WriteFile(clazz.getServiceFile(), vf.getWriter());
    }

    /**
     * service implement
     */
    public static void buildServiceImpl(ServiceImplPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), po);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRight.AUTHOR);
        map.put("copyright", CopyRight.COPYRIGHT);
        map.put("base", po.getBasePackage());

        map.put("model", po.getModel());
        map.put("model_1", StringMatch.first2Lowercase(po.getModel()));
        map.put("import_model", clazz.getModelPackageClazz());
        map.put("import_dao", clazz.getDAOPackageClazz());
        map.put("import_service", clazz.getServicePackageClazz());
        map.put("service_impl_package", pack.getServiceImplPackage());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.SERVICE_IMPL_VM, map);
        new WriteFile(clazz.getServiceImplFile(), vf.getWriter());
    }

    /**
     * sql
     */
    public static void buildIbatisSQL(SqlXMLPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), po);
        SqlMapBean smb = new SqlMapBean(po.getProperty(), po.getFinder());

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRight.AUTHOR);
        map.put("copyright", CopyRight.COPYRIGHT);

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

    /**
     * web form
     */
    public static void buildForm(FormPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), po);
        ModelClazzBean mcb = new ModelClazzBean(po);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRight.AUTHOR);
        map.put("copyright", CopyRight.COPYRIGHT);

        map.put("model", po.getModel());
        map.put("model_1", StringMatch.first2Lowercase(po.getModel()));
        map.put("form_package", pack.getFormWebPackage());
        map.put("import_model", clazz.getModelPackageClazz());
        map.put("model_constructorMethods", mcb.getConstructorMethod());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.FORM_MODEL_VM, map);
        new WriteFile(clazz.getWebFormFile(), vf.getWriter());
    }

    /**
     * ibatis implemention
     * 
     * @param po
     */
    @Deprecated
    public static void buildIbatis(IbatisPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), po);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRight.AUTHOR);
        map.put("copyright", CopyRight.COPYRIGHT);
        map.put("base", po.getBasePackage());

        map.put("model", po.getModel());
        map.put("model_1", StringMatch.first2Lowercase(po.getModel()));
        map.put("import_model", clazz.getModelPackageClazz());
        map.put("import_dao", clazz.getDAOPackageClazz());
        map.put("dao_ibatis_package", pack.getIbatisPackage());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.IBATIS_VM, map);
        new WriteFile(clazz.getIbatisFile(), vf.getWriter());
    }

    /**
     * dao test
     */
    @Deprecated
    public static void buildIbatisTest(TestPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), po);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRight.AUTHOR);
        map.put("copyright", CopyRight.COPYRIGHT);
        map.put("base", po.getBasePackage());

        map.put("model", po.getModel());
        map.put("model_1", StringMatch.first2Lowercase(po.getModel()));
        map.put("import_model", clazz.getModelPackageClazz());
        map.put("import_dao", clazz.getDAOPackageClazz());
        map.put("dao_ibatis_package", pack.getIbatisPackage());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.IBATIS_TEST_VM, map);
        new WriteFile(clazz.getIbatisTestFile(), vf.getWriter());
    }

    /**
     * module model
     */
    @Deprecated
    public static void buildModuleModel(ModuleModelPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModule(), po);
        ModelClazzBean mcb = new ModelClazzBean(po);

        // try {
        // CreateFactory.createClazz(clazz.getModelModuleFile());
        // } catch (IOException ex) {
        // Logger.getLogger(BuildModuleModelFile.class.getName()).log(Level.SEVERE,
        // null, ex);
        // }
        // System.out.println(clazz.getModelModuleFile());

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRight.AUTHOR);
        map.put("copyright", CopyRight.COPYRIGHT);
        map.put("base", po.getBasePackage());

        map.put("model", po.getModuleModel());
        map.put("model_package", pack.getModelPackage());
        map.put("model_constructorMethods", mcb.getConstructorMethod());
        map.put("model_properties", mcb.getProperties());
        map.put("model_setMethods", mcb.getSetMethod());
        map.put("model_getMethods", mcb.getGetMethod());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.MODEL_VM, map);
        new WriteFile(clazz.getModelModuleFile(), vf.getWriter());
    }

}
