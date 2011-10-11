package org.conan.tools.core.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Conan
 */
public class SqlMapBean {

    public SqlMapBean(List<PropertyBean> propertiesBean, List<SqlFinderBean> findersBean) {
        propertiesBean = sortPropery(propertiesBean);
        setSqlResultMaps(propertiesBean);
        setSqlSelects(propertiesBean);
        setSqlConditions(propertiesBean);
        setSqlUpdates(propertiesBean);
        setSqlInsertsValue(propertiesBean);
        setSqlInsertsName(propertiesBean);
        setSqlFinders(findersBean);
    }

    private List<String> sqlResultMaps = new ArrayList<String>(10);
    private List<String> sqlSelects = new ArrayList<String>(10);
    private List<String> sqlConditions = new ArrayList<String>(10);
    private List<String> sqlUpdates = new ArrayList<String>(10);
    private List<String> sqlInsertsName = new ArrayList<String>(10);
    private List<String> sqlInsertsValue = new ArrayList<String>(10);
    private List<String> sqlFinders = new ArrayList<String>(10);

    private List<PropertyBean> sortPropery(List<PropertyBean> propertiesBean) {
        for (int i = 0; i < propertiesBean.size(); i++) {
            PropertyBean pb = propertiesBean.get(i);
            if (!pb.isNull()) {
                propertiesBean.add(pb);
                propertiesBean.remove(i);
                break;
            }
        }
        return propertiesBean;
    }

    public List<String> getSqlInsertsName() {
        return sqlInsertsName;
    }

    public List<String> getSqlInsertsValue() {
        return sqlInsertsValue;
    }

    public List<String> getSqlUpdates() {
        return sqlUpdates;
    }

    public List<String> getSqlConditions() {
        return sqlConditions;
    }

    public List<String> getSqlResultMaps() {
        return sqlResultMaps;
    }

    public List<String> getSqlSelects() {
        return sqlSelects;
    }

    public List<String> getSqlFinders() {
        return sqlFinders;
    }

    public void setSqlConditions(List<PropertyBean> propertiesBean) {
        for (PropertyBean pb : propertiesBean) {
            StringBuilder sb = new StringBuilder();
            sb.append("<if test=\"" + pb.getName() + "!=null\">");
            if (pb.getName().equalsIgnoreCase("password")) {
                sb.append(pb.getName() + " = password(#{" + pb.getName() + "}) and");
            } else {
                sb.append(pb.getName() + " = #{" + pb.getName() + "} and");
            }
            sb.append("</if>");
            sqlConditions.add(sb.toString());
        }
    }

    public void setSqlResultMaps(List<PropertyBean> propertiesBean) {
        for (PropertyBean pb : propertiesBean) {
            StringBuilder sb = new StringBuilder();
            sb.append("<result property=\"" + pb.getName() + "\" ");
            sb.append("column=\"" + pb.getName() + "\" ");
            
            if (pb.getType().equalsIgnoreCase("timestamp")) {
                sb.append("javaType=\"java.sql." + pb.getType() + "\"/>");
            } else if (pb.getType().equalsIgnoreCase("date")) {
                sb.append("javaType=\"java.util." + pb.getType() + "\"/>");
            } else {
                sb.append("javaType=\"" + pb.getType() + "\"/>");
            }

            sqlResultMaps.add(sb.toString());
        }
    }

    public void setSqlSelects(List<PropertyBean> propertiesBean) {
        for (int i = 0; i < propertiesBean.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(propertiesBean.get(i).getName());
            if (i != propertiesBean.size() - 1) {
                sb.append(",");
            }
            sqlSelects.add(sb.toString());
        }
    }

    public void setSqlUpdates(List<PropertyBean> propertiesBean) {
        for (int i = 0; i < propertiesBean.size(); i++) {
            StringBuilder sb = new StringBuilder();
            String name = propertiesBean.get(i).getName();

            sb.append("<if test=\"" + name + "!=null\">");
            if (name.equalsIgnoreCase("password")) {
                sb.append(name + " = password(#{" + name + "})");
            } else {
                sb.append(name + " = #{" + name + "}");
            }
            sb.append(",");
            sb.append("</if>");
            sqlUpdates.add(sb.toString());
        }
    }

    public void setSqlInsertsValue(List<PropertyBean> propertiesBean) {
        for (int i = 0; i < propertiesBean.size(); i++) {
            StringBuilder sb = new StringBuilder();
            String name = propertiesBean.get(i).getName();
            boolean _null = propertiesBean.get(i).isNull();

            if (_null) {
                sb.append("<if test=\"" + name + "!=null\">");
            }
            if (name.equalsIgnoreCase("password")) {
                sb.append("password(#{" + name + "})");
            } else {
                sb.append("#{" + name + "}");
            }
            if (i != propertiesBean.size() - 1) {
                sb.append(",");
            }
            if (_null) {
                sb.append("</if>");
            }
            sqlInsertsValue.add(sb.toString());
        }
    }

    public void setSqlInsertsName(List<PropertyBean> propertiesBean) {
        for (int i = 0; i < propertiesBean.size(); i++) {
            StringBuilder sb = new StringBuilder();
            String name = propertiesBean.get(i).getName();
            boolean _null = propertiesBean.get(i).isNull();

            if (_null) {
                sb.append("<if test=\"" + name + "!=null \">");
            }
            sb.append(name);
            if (i != propertiesBean.size() - 1) {
                sb.append(",");
            }
            if (_null) {
                sb.append("</if>");
            }
            sqlInsertsName.add(sb.toString());
        }
    }

    public void setSqlFinders(List<SqlFinderBean> findersBean) {
        for (SqlFinderBean bean : findersBean) {
            StringBuilder sb = new StringBuilder();
            sb.append("<select id=\"");
            sb.append(bean.getId());
            sb.append("\" parameterType=\"java.util.Map\" resultType=\"java.util.HashMap\" remapResults=\"true\">\n");
            // sb.append("<![CDATA[");
            sb.append(bean.getSql());
            // sb.append("]]>\n");
            sb.append("</select>");
            sqlFinders.add(sb.toString());
        }
    }
}
