package org.conan.tools;

import org.conan.tools.core.JAXBMarshaller;
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
        ParamObject po = new ParamObject(obj);

        CreateFactory.createFile(po);
        CreateFactory.createContent(po);
    }

    public static void main(String[] args) {
        init();
    }
}
