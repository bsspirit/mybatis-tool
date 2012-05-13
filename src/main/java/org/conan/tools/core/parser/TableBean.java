package org.conan.tools.core.parser;

import java.util.ArrayList;
import java.util.List;

public class TableBean {

    private String table;
    private List<PropertyBean> pbs = new ArrayList<PropertyBean>();

    public TableBean(String table) {
        this.table = table;
    }

    public TableBean(String table, List<PropertyBean> pbs) {
        this.table = table;
        this.pbs.addAll(pbs);
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<PropertyBean> getPbs() {
        return pbs;
    }

    public void setPbs(List<PropertyBean> pbs) {
        this.pbs = pbs;
    }

    public String getSqlCreateTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + table + "(\n");
        sb.append("    id INT PRIMARY KEY AUTO_INCREMENT,\n");
        for (PropertyBean pb : pbs) {
            sb.append("    " + pb.getName());

            if (pb.getType().equalsIgnoreCase("long")) {
                sb.append(" BIGINT");
            } else {
                sb.append(" " + pb.getType().toUpperCase());
            }

            sb.append(" " + (pb.isNull() ? "NULL" : "NOT NULL"));
            sb.append(" " + (pb.isUnique() ? "UNIQUE" : ""));

            if (pb.getDefault() != null) {
                String defaultStr = pb.getDefault();
                if (pb.getType().toUpperCase().contains("CHAR")) {
                    defaultStr = "'" + pb.getDefault() + "'";
                }
                sb.append(" " + (pb.getDefault() != null ? "DEFAULT " + defaultStr : ""));
            }
            sb.append(",");
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append(")ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");
        return sb.toString();
    }

}
