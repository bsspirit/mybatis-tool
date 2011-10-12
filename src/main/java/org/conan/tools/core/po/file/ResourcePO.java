package org.conan.tools.core.po.file;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.conan.tools.core.build.CreateFactory;
import org.conan.tools.core.build.tree.ResourceTree;

public class ResourcePO extends FilePO {

    public ResourcePO(String root) {
        super(root);
    }

    @Override
    public void create() {
        ResourceTree res = new ResourceTree(root);
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

}
