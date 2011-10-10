package org.conan.tools.core.build.dir;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.conan.tools.core.build.tree.ResourceTree;
import org.conan.tools.core.model.FilePO;

public class CreateResource {

    public CreateResource(FilePO po) {
        ResourceTree res = new ResourceTree(po);
        List<String> trees = res.getTreeFile();
        for (String tree : trees) {
            try {
                new File(tree).createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(CreateClazz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(res.printTreeFile());
    }

}
