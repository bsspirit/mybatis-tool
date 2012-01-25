package org.conan.tools.core.po.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.conan.tools.core.build.VelocityFactory;
import org.conan.tools.core.build.tree.ResourceTree;
import org.conan.tools.core.po.file.FilePO;
import org.conan.tools.core.xmlloader.ModuleType;
import org.conan.tools.util.io.WriteFile;

public class SpringServiceXMLPO extends FilePO {

    protected List<ModuleType> modules;
    protected String project;

    public SpringServiceXMLPO() {
    }

    public SpringServiceXMLPO(String root, String project, List<ModuleType> modules) {
        super(root);
        this.project = project;
        this.modules = modules;
    }

    public List<String> getModules() {
        List<String> list = new ArrayList<String>();
        for (ModuleType m : modules) {
            list.add(m.getName());
        }
        return list;
    }

    public String getProject() {
        return project;
    }

    @Override
    public void create() {
        ResourceTree res = new ResourceTree(this.root);

        Map<String, Object> map = this.getVMMap();
        map.put("modules", this.getModules());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.CONFIG_SPRING_SERVICE_VM, map);
        new WriteFile(res.getSpringServiceFile(), vf.getWriter());
    }

}
