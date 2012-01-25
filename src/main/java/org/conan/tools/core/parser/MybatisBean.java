package org.conan.tools.core.parser;

import java.util.ArrayList;
import java.util.List;

public class MybatisBean {

    private List<String> typeAlias = new ArrayList<String>();
    private List<String> mapper = new ArrayList<String>();

    public MybatisBean(List<TypeAliasBean> alias, List<String> xmls) {
        setTypeAlias(alias);
        setMapper(xmls);
    }

    public void setTypeAlias(List<TypeAliasBean> alias) {
        for (TypeAliasBean alia : alias) {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t<typeAlias alias=\"" + alia.getAlias() + "\" type=\"" + alia.getType() + "\"/>");
            typeAlias.add(sb.toString());
        }
    }

    public void setMapper(List<String> xmlx) {
        for (String xml : xmlx) {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t<mapper resource=\"" + xml + "\" />");
            mapper.add(sb.toString());
        }
    }

    public List<String> getTypeAlias() {
        return typeAlias;
    }

    public List<String> getMapper() {
        return mapper;
    }

}
