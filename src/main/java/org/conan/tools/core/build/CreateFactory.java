package org.conan.tools.core.build;

import org.conan.tools.core.parser.ParamObject;

final public class CreateFactory {

    public static void createFile(ParamObject po) {
        po.getFolderPO().create();
        po.getResourcePO().create();
        po.getPackagePO().create();
        po.getClazzPO().create();
    }

    public static void createContent(ParamObject po) {
        po.getSpringServicePO().create();
        po.getModelPO().create();
        po.getFormPO().create();
        po.getDaoPO().create();
        po.getSqlXMLPO().create();
        po.getServicePO().create();
        po.getServiceImpl().create();
        po.getSqlCreatePO().create();
        po.getSqlDropPO().create();
        po.getServiceTestPO().create();
    }

    // /**
    // * 文件夹
    // */
    // public static void createFolder(FilePO po) {
    // FolderTree pack = new FolderTree(po);
    // List<String> trees = pack.getTreeFile();
    // for (String tree : trees) {
    // new File(tree).mkdirs();
    // }
    // System.out.println(pack.printTreeFile());
    // }

    // /**
    // * 类包
    // */
    // public static void createPackage(PackagePO po) {
    // for (ModuleType module : po.getModules()) {
    // PackageTree pack = new PackageTree(po.getRoot(), po.getBasePackage(),
    // module.getName());
    // List<String> trees = pack.getTreeFile();
    // for (String tree : trees) {
    // new File(tree).mkdirs();
    // }
    // System.out.println(pack.printTreeFile());
    // }
    // }

    // /**
    // * 资源文件
    // */
    // public static void createResource(FilePO po) {
    // ResourceTree res = new ResourceTree(po);
    // List<String> trees = res.getTreeFile();
    // for (String tree : trees) {
    // try {
    // new File(tree).createNewFile();
    // } catch (IOException ex) {
    // Logger.getLogger(CreateFactory.class.getName()).log(Level.SEVERE, null,
    // ex);
    // }
    // }
    // System.out.println(res.printTreeFile());
    // }

    // /**
    // * 类文件
    // */
    // public static void createClazz(ClazzPO po) {
    // for (ModuleType module : po.getModules()) {
    // for (ModelType model : module.getModel()) {
    // ClazzTree pack = new ClazzTree(po.getRoot(), po.getBasePackage(),
    // module.getName(), model.getName());
    // List<String> trees = pack.getTreeFile();
    // for (String tree : trees) {
    // new File(tree).mkdirs();
    // }
    // System.out.println(pack.printTreeFile());
    // }
    // }
    // }

}
