package org.conan.tools.core.po.config;

import java.util.ArrayList;
import java.util.List;

import org.conan.tools.core.po.file.FilePO;

public class SpringDaoXMLPO extends FilePO {

    private List<String> modules = new ArrayList<String>();
    private String project;

    public SpringDaoXMLPO() {
    }

    public SpringDaoXMLPO(String root, String project) {
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
