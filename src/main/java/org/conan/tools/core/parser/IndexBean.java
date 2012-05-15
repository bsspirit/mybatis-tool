package org.conan.tools.core.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Conan
 */
public class IndexBean {
    
    private List<String> name = new ArrayList<String>();
    private String type;
    
    public IndexBean(String type, List<String> names) {
        this.name.addAll(names);
        this.type = type;
    }
    
    public IndexBean() {
    }
    
    public List<String> getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
}
