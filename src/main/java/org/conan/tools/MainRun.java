package org.conan.tools;

import org.conan.tools.core.JAXBMarshaller;
import org.conan.tools.core.build.BuildFactory;
import org.conan.tools.core.build.CreateFactory;
import org.conan.tools.core.parser.ParamObject;
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
    }

    public static void main(String[] args) {
        init();
    }
}
