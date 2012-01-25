package org.conan.tools.core.po.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.conan.tools.core.build.VelocityFactory;
import org.conan.tools.core.build.tree.ResourceTree;
import org.conan.tools.core.parser.MybatisBean;
import org.conan.tools.core.parser.TypeAliasBean;
import org.conan.tools.core.po.file.ClazzPO;
import org.conan.tools.core.xmlloader.ModelType;
import org.conan.tools.core.xmlloader.ModuleType;
import org.conan.tools.util.io.WriteFile;
import org.conan.tools.util.match.StringMatch;

/**
 * 
 * @author Conan
 */
public class MybatisXMLPO extends ClazzPO {

    private MybatisBean mybatisBean;

    public MybatisXMLPO(String root, String basePackage, List<ModuleType> modules) {
        super(root, basePackage, modules);
    }

    public MybatisXMLPO() {
    }

    @Override
    public void create() {
        List<TypeAliasBean> alias = new ArrayList<TypeAliasBean>();
        List<String> mapper = new ArrayList<String>();
        for (ModuleType module : getModuleTypes()) {
            for (ModelType model : module.getModel()) {
                String dto = model.getName() + "DTO";
                String pack_mod = this.basePackage + "." + module.getName();
                alias.add(new TypeAliasBean(dto, pack_mod + ".model." + StringMatch.first2Uppercase(dto)));
                mapper.add(StringMatch.point2left(pack_mod + ".dao." + model.getName()) + ".xml");
            }
        }

        mybatisBean = new MybatisBean(alias, mapper);
        ResourceTree res = new ResourceTree(this.root);
        Map<String, Object> map = this.getVMMap();
        map.put("xml_mappers", mybatisBean.getMapper());
        map.put("type_alias", mybatisBean.getTypeAlias());

        VelocityFactory vf = new VelocityFactory(VelocityFactory.CONFIG_MYBATIS_VM, map);
        new WriteFile(res.getMybatisFile(), vf.getWriter());

    }
}
