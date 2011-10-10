package org.conan.tools;

import org.conan.tools.core.JAXBMarshaller;
import org.conan.tools.core.build.BuildFactory;
import org.conan.tools.core.build.CreateFactory;
import org.conan.tools.core.model.ParamObject;
import org.conan.tools.core.xmlloader.DaoToolType;

/**
 * 
 * @author conan
 */
public class MainRun {

    public static void init() {
        DaoToolType obj = JAXBMarshaller.unmarshaller("daoTool-config.xml");
        ParamObject po = new ParamObject();
        po.init(obj);

        CreateFactory.createALL(po);
        BuildFactory.buildALL(po);

        // // model
        // for (ModelPO model : po.getModelList()) {
        // new BuildModelFile(model);
        // }
        //
        // for (DaoPO dao : po.getDaoList()) {
        // new BuildDAOFile(dao);
        // }
        //
        // for (SqlPO sql : po.getSqlList()) {
        // new BuildIbatisSQLFile(sql);
        // }
        // for (ServicePO service : po.getServiceList()) {
        // new BuildServiceFile(service);
        // }
        //
        // for (ServiceImplPO serviceImpl : po.getServiceImplList()) {
        // new BuildServiceImplFile(serviceImpl);
        // }
        // -------------------------------


       

        // for (FormPO form : po.getFormList()) {
        // new BuildFormFile(form);
        // }

        // new BuildSQLCreateFile(po.getSqlCreate());

        // /////////////////////////////////////////////
        // for (TestPO test : po.getTestList()) {
        // new BuildIbatisTestFile(test);
        // }
        // for (IbatisPO ibatis : po.getIbatisList()) {
        // new BuildIbatisFile(ibatis);
        // }
        // for (ModuleModelPO mm : po.getMmList()) {
        // new BuildModuleModelFile(mm);
        // }
        // //////////////////////////////////////////////

    }

    public static void main(String[] args) {
        init();
    }
}
