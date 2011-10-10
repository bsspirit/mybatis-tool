package org.conan.tools;

import org.conan.tools.core.JAXBMarshaller;
import org.conan.tools.core.build.dao.BuildDAOFile;
import org.conan.tools.core.build.dao.BuildIbatisSQLFile;
import org.conan.tools.core.build.dir.CreateClazz;
import org.conan.tools.core.build.dir.CreatePackage;
import org.conan.tools.core.build.model.BuildModelFile;
import org.conan.tools.core.build.service.BuildServiceFile;
import org.conan.tools.core.build.service.BuildServiceImplFile;
import org.conan.tools.core.build.web.BuildFormFile;
import org.conan.tools.core.model.ClazzPO;
import org.conan.tools.core.model.DaoPO;
import org.conan.tools.core.model.FormPO;
import org.conan.tools.core.model.ModelPO;
import org.conan.tools.core.model.PackagePO;
import org.conan.tools.core.model.ParamObject;
import org.conan.tools.core.model.ServiceImplPO;
import org.conan.tools.core.model.ServicePO;
import org.conan.tools.core.model.SqlPO;
import org.conan.tools.core.xmlloader.DaoToolType;

/**
 * 
 * @author conan
 */
public class BuildRun {
    
    public static void init() {
        DaoToolType obj = JAXBMarshaller.unmarshaller("daoTool-config.xml");
        ParamObject po = new ParamObject();
        po.init(obj);

        for (PackagePO pack : po.getPackageList()) {
            new CreatePackage(pack);
        }

        for (ClazzPO clazz : po.getClazzList()) {
            new CreateClazz(clazz);
        }

        for (ModelPO model : po.getModelList()) {
            new BuildModelFile(model);
        }

        for (DaoPO dao : po.getDaoList()) {
            new BuildDAOFile(dao);
        }

        for (ServicePO service : po.getServiceList()) {
            new BuildServiceFile(service);
        }

        for (ServiceImplPO serviceImpl : po.getServiceImplList()) {
            new BuildServiceImplFile(serviceImpl);
        }

        for (SqlPO sql : po.getSqlList()) {
            new BuildIbatisSQLFile(sql);
        }
        for (FormPO form : po.getFormList()) {
            new BuildFormFile(form);
        }

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
