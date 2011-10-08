/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.clazz;

import java.util.ArrayList;
import java.util.List;
import org.conan.tools.util.match.StringMatch;

/**
 *
 * @author Conan
 */
public class MethodBean {

    private List<PropertyBean> pbs;
    private String model;

    public MethodBean(String model, List<PropertyBean> pbs) {
        this.pbs = pbs;
        this.model = model;
    }

    public String getGetMethod() {
        StringBuilder sb = new StringBuilder();
        for (PropertyBean pb : pbs) {
            sb.append("public " + pb.getType() + " get" + StringMatch.first2Uppercase(pb.getName()) + " (){\n");
            sb.append("return this." + pb.getName() + ";\n");
            sb.append("}\n");
        }
        return sb.toString();
    }

    public String getSetMethod() {
        StringBuilder sb = new StringBuilder();
        for (PropertyBean pb : pbs) {
            sb.append("public void set" + StringMatch.first2Uppercase(pb.getName()) + "(" + pb.getTypeName() + ") {\n");
            sb.append("this." + pb.getName() + " = " + pb.getName() + ";\n");
            sb.append("}\n");
        }
        return sb.toString();
    }

    public String getConstructorMethod() {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < pbs.size(); i++) {
            PropertyBean pb0 = pbs.get(i);
            sb1.append(pb0.getTypeName());
            if (i < pbs.size() - 1) {
                sb1.append(", ");
            }
            sb2.append("this." + pb0.getName() + " = " + pb0.getName() + ";\n");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("public " + StringMatch.first2Uppercase(model) + "DTO(){}\n");
        sb.append("public " + StringMatch.first2Uppercase(model) + "DTO(" + sb1.toString() + "){\n");
        sb.append(sb2.toString());
        sb.append("}\n");
        return sb.toString();
    }

    public String getConstructorFormMethod(){
        StringBuilder sb1 = new StringBuilder();
         sb1.append(StringMatch.first2Uppercase(model)+"DTO dto");

        StringBuilder sb2 = new StringBuilder();
        sb2.append("super.setId(dto.getId());\n");
        for (int i = 0; i < pbs.size(); i++) {
            PropertyBean pb = pbs.get(i);
            sb2.append("super.set"+StringMatch.first2Uppercase(pb.getName()) + "(dto.get" + StringMatch.first2Uppercase(pb.getName()) + "());\n");

        }

        StringBuilder sb = new StringBuilder();
        sb.append("public " + StringMatch.first2Uppercase(model) + "Form(){}\n");
        sb.append("public " + StringMatch.first2Uppercase(model) + "Form(" + sb1.toString() + "){\n");
        sb.append(sb2.toString());
        sb.append("}\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new PropertyBean("name", "String"));
        list.add(new PropertyBean("age", "Integer"));

        MethodBean mb = new MethodBean("user", list);
        System.out.println(mb.getGetMethod());
        System.out.println(mb.getSetMethod());
        System.out.println(mb.getConstructorMethod());
    }
}
