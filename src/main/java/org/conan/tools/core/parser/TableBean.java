package org.conan.tools.core.parser;

import java.util.ArrayList;
import java.util.List;

import org.conan.tools.util.match.StringMatch;

public class TableBean {
    
    private String table;
    private List<PropertyBean> pbs = new ArrayList<PropertyBean>();
    private List<IndexBean> ibs = new ArrayList<IndexBean>();
    
    public TableBean(String table) {
        this.table = table;
    }
    
    public TableBean(String table, List<PropertyBean> pbs, List<IndexBean> ibs) {
        this.table = table;
        this.pbs.addAll(pbs);
        this.ibs.addAll(ibs);
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
    
    public List<IndexBean> getIbs() {
        return ibs;
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
        
        for (int i = 0; i < ibs.size(); i++) {
            IndexBean ib = ibs.get(i);
            sb.append("CREATE " + (ib.getType()!=null && ib.getType().equalsIgnoreCase("UNIQUE") ? ib.getType().toUpperCase() : ""));
            sb.append(" INDEX " + table + "_IDX_" + i);
            sb.append(" on " + table + "(" + StringMatch.stringLines(ib.getName()) + ");\n");
        }
        return sb.toString();
    }
    
}
