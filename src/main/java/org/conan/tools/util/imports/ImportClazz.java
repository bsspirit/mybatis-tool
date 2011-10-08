/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.util.imports;

import org.conan.tools.core.xmlloader.TypeSType;

/**
 *
 * @author conan
 */
public class ImportClazz {

    public static String getImport(TypeSType name) {
        String tmp = null;
        switch (name) {
            case TIMESTAMP:
                tmp = "java.sql.Timestamp";
                break;
            case DATE:
            	tmp ="java.util.Date";
            	break;
        }
        return tmp;
    }
}
