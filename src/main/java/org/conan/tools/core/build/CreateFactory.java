package org.conan.tools.core.build;

import org.conan.tools.core.parser.ParamObject;
/**
 * 
 * @author Conan
 */
final public class CreateFactory {

    public static void createFile(ParamObject po) {
        po.getFolderPO().create();
        po.getResourcePO().create();
        po.getPackagePO().create();
        po.getClazzPO().create();
    }

    public static void createContent(ParamObject po) {
        po.getSpringServicePO().create();
        po.getModelPO().create();
        po.getFormPO().create();
        po.getDaoPO().create();
        po.getSqlXMLPO().create();
        po.getServicePO().create();
        po.getServiceImpl().create();
        po.getSqlCreatePO().create();
        po.getSqlDropPO().create();
        po.getServiceTestPO().create();
        po.getSpringDaoXMLPO().create();
        po.getMybatisXMLPO().create();
    }

}
