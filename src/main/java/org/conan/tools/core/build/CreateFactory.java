package org.conan.tools.core.build;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.conan.tools.core.build.tree.ClazzTree;
import org.conan.tools.core.build.tree.FolderTree;
import org.conan.tools.core.build.tree.PackageTree;
import org.conan.tools.core.build.tree.ResourceTree;
import org.conan.tools.core.model.ClazzPO;
import org.conan.tools.core.model.FilePO;
import org.conan.tools.core.model.PackagePO;
import org.conan.tools.core.parser.ParamObject;

final public class CreateFactory {

    public static void createALL(ParamObject po) {
        createFolder(po.getFilePO());// 文件夹
        createResource(po.getFilePO());// 资源文件
        for (PackagePO pack : po.getPackageList()) {// 类包
            createPackage(pack);
        }
        for (ClazzPO clazz : po.getClazzList()) {// 类文件
            createClazz(clazz);
        }
    }

    /**
     * 文件夹
     */
    public static void createFolder(FilePO po) {
        FolderTree pack = new FolderTree(po);
        List<String> trees = pack.getTreeFile();
        for (String tree : trees) {
            new File(tree).mkdirs();
        }
        System.out.println(pack.printTreeFile());
    }

    /**
     * 类包
     */
    public static void createPackage(PackagePO po) {
        PackageTree pack = new PackageTree(po);
        List<String> trees = pack.getTreeFile();
        for (String tree : trees) {
            new File(tree).mkdirs();
        }
        System.out.println(pack.printTreeFile());
    }

    /**
     * 资源文件
     */
    public static void createResource(FilePO po) {
        ResourceTree res = new ResourceTree(po);
        List<String> trees = res.getTreeFile();
        for (String tree : trees) {
            try {
                new File(tree).createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(CreateFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(res.printTreeFile());
    }

    /**
     * 类文件
     */
    public static void createClazz(ClazzPO po) {
        ClazzTree clazz = new ClazzTree(po);
        List<String> trees = clazz.getTreeFile();
        for (String tree : trees) {
            try {
                new File(tree).createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(CreateFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(clazz.printTreeFile());
    }

}
