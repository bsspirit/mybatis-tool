/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.xml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.conan.tools.core.xmlloader.DaoToolType;
import org.conan.tools.core.xmlloader.ModelType;
import org.conan.tools.core.xmlloader.ModuleType;
import org.conan.tools.core.xmlloader.ModulesType;
import org.conan.tools.core.xmlloader.PropType;
import org.conan.tools.core.xmlloader.TypeSType;

/**
 * 
 * @author conan
 */
public class JAXBMarshaller {

    public static void marshaller() {
        try {
            PropType prop0 = new PropType();
            prop0.setName("name");
            prop0.setType(TypeSType.STRING);
            PropType prop1 = new PropType();
            prop1.setName("description");
            prop1.setType(TypeSType.STRING);
            PropType prop2 = new PropType();
            prop2.setName("parentId");
            prop2.setType(TypeSType.INTEGER);

            ModelType model = new ModelType();
            model.setName("Group");
            model.getProp().add(prop0);
            model.getProp().add(prop1);
            model.getProp().add(prop2);

            ModuleType module = new ModuleType();
            module.setName("privilege");
            module.getModel().add(model);

            ModulesType modules = new ModulesType();
            modules.getModule().add(module);

            DaoToolType bm = new DaoToolType();
            bm.setFilePath("/home/conan/workspace/netbeans/BookMoochTool/metadata/gen");
            bm.setProject("org.conan.bookmooch");
            bm.setModules(modules);

            JAXBContext jc = JAXBContext.newInstance("org.conan.tools.core.xmlloader");
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            FileOutputStream os = new FileOutputStream("bookmooch-config.xml");
            m.marshal(bm, os);
            os.close();

        } catch (Exception ex) {
            Logger.getLogger(JAXBMarshaller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DaoToolType unmarshaller(String name) {
        DaoToolType bm = null;
        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance("org.conan.tools.core.xmlloader");
            Unmarshaller um = jc.createUnmarshaller();
            InputStream is = new FileInputStream(name);
            JAXBElement o = (JAXBElement) um.unmarshal(is);
            bm = (DaoToolType) o.getValue();
            is.close();
        } catch (Exception ex) {
            Logger.getLogger(JAXBMarshaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(bm);
        return bm;
    }

    public static void main(String[] args) {
        marshaller();
        unmarshaller("daoTool-config.xml");
    }
}
