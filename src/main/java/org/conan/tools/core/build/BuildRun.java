package org.conan.tools.core.build;

import org.conan.tools.core.model.ClazzPO;
import org.conan.tools.core.model.DaoPO;
import org.conan.tools.core.model.FormPO;
import org.conan.tools.core.model.ModelPO;
import org.conan.tools.core.model.PackagePO;
import org.conan.tools.core.model.ParamObject;
import org.conan.tools.core.model.SqlPO;
import org.conan.tools.core.xml.MarshallerBookMooch;
import org.conan.tools.core.xmlloader.DaoToolType;

/**
 * 
 * @author conan
 */
public class BuildRun {

    public static void init() {
        DaoToolType obj = MarshallerBookMooch.unmarshaller();
        ParamObject po = new ParamObject();
        po.init(obj);

        for (PackagePO pack : po.getPackageList()) {
            new BuildPackage(pack);
        }

        for (ClazzPO clazz : po.getClazzList()) {
            new BuildClazz(clazz);
        }

        for (ModelPO model : po.getModelList()) {
            new BuildModelFile(model);
        }

        for (DaoPO dao : po.getDaoList()) {
            new BuildDAOFile(dao);
        }

        for (SqlPO sql : po.getSqlList()) {
            new BuildIbatisSQLFile(sql);
        }

        // for (TestPO test : po.getTestList()) {
        // new BuildIbatisTestFile(test);
        // }
        // for (IbatisPO ibatis : po.getIbatisList()) {
        // new BuildIbatisFile(ibatis);
        // }
        // for (ModuleModelPO mm : po.getMmList()) {
        // new BuildModuleModelFile(mm);
        // }

        for (FormPO form : po.getFormList()) {
            new BuildFormFile(form);
        }

    }

    public static void main(String[] args) {
        init();
    }
}
