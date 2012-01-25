package org.conan.tools.core.po.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.conan.tools.core.build.VelocityFactory;
import org.conan.tools.core.build.tree.ResourceTree;
import org.conan.tools.core.parser.DaoBean;
import org.conan.tools.core.parser.SpringBean;
import org.conan.tools.core.po.file.ClazzPO;
import org.conan.tools.core.xmlloader.ModelType;
import org.conan.tools.core.xmlloader.ModuleType;
import org.conan.tools.util.io.WriteFile;
import org.conan.tools.util.match.StringMatch;

public class SpringDaoXMLPO extends ClazzPO {

    private SpringBean springBean;

    public SpringDaoXMLPO(String root, String basePackage, List<ModuleType> modules) {
        super(root, basePackage, modules);
    }

    public SpringDaoXMLPO() {
    }

    @Override
    public void create() {
        List<DaoBean> list = new ArrayList<DaoBean>();
        for (ModuleType module : getModuleTypes()) {
            for (ModelType model : module.getModel()) {
                String id = model.getName() + "DAO";
                String value = this.basePackage + "." + module.getName() + ".dao." + StringMatch.first2Uppercase(id);
                list.add(new DaoBean(id, value));
            }
        }

        springBean = new SpringBean(list);
        ResourceTree res = new ResourceTree(this.root);
        Map<String, Object> map = this.getVMMap();
        map.put("dao_beans", springBean.getDAOBean());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.CONFIG_SPRING_DAO_VM, map);
        new WriteFile(res.getSpringDAOFile(), vf.getWriter());

    }

}
