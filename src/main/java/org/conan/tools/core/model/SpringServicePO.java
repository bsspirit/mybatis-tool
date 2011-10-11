package org.conan.tools.core.model;

import java.util.ArrayList;
import java.util.List;

public class SpringServicePO extends FilePO {

    private List<String> modules = new ArrayList<String>();
    private String project;

    public SpringServicePO() {
    }

    public SpringServicePO(String root, String project) {
        super(root);
        this.project = project;
    }

    public List<String> getModules() {
        return modules;
    }

    public String getProject() {
        return project;
    }

}
