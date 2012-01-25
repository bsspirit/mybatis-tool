package org.conan.tools.core.po.file;

import java.io.File;
import java.util.List;

import org.conan.tools.core.build.tree.FolderTree;

public class FolderPO extends FilePO {

    public FolderPO(String root) {
        super(root);
    }

    @Override
    public void create() {
        FolderTree pack = new FolderTree(root);
        List<String> trees = pack.getTreeFile();
        for (String tree : trees) {
            new File(tree).mkdirs();
        }
        System.out.println(pack.printTreeFile());
    }

}
