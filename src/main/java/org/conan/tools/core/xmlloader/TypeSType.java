//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.10.10 at 05:22:25 ���� CST 
//


package org.conan.tools.core.xmlloader;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeSType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="typeSType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Boolean"/>
 *     &lt;enumeration value="String"/>
 *     &lt;enumeration value="Integer"/>
 *     &lt;enumeration value="Long"/>
 *     &lt;enumeration value="Float"/>
 *     &lt;enumeration value="Double"/>
 *     &lt;enumeration value="Timestamp"/>
 *     &lt;enumeration value="Date"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "typeSType")
@XmlEnum
public enum TypeSType {

    @XmlEnumValue("Boolean")
    BOOLEAN("Boolean"),
    @XmlEnumValue("String")
    STRING("String"),
    @XmlEnumValue("Integer")
    INTEGER("Integer"),
    @XmlEnumValue("Long")
    LONG("Long"),
    @XmlEnumValue("Float")
    FLOAT("Float"),
    @XmlEnumValue("Double")
    DOUBLE("Double"),
    @XmlEnumValue("Timestamp")
    TIMESTAMP("Timestamp"),
    @XmlEnumValue("Date")
    DATE("Date");
    private final String value;

    TypeSType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeSType fromValue(String v) {
        for (TypeSType c: TypeSType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
