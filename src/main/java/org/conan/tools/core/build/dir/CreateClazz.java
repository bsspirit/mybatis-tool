package org.conan.tools.core.build.dir;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.conan.tools.core.build.tree.ClazzTree;
import org.conan.tools.core.model.ClazzPO;

/**
 * 
 * @author Conan
 */
public class CreateClazz {

    public CreateClazz(ClazzPO po) {
        ClazzTree clazz = new ClazzTree(po.getModel(), po);
        List<String> trees = clazz.getTreeFile();
        for (String tree : trees) {
            try {
                create(tree);
            } catch (IOException ex) {
                Logger.getLogger(CreateClazz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(clazz.printTreeFile());
    }

    private void create(String file) throws IOException {
        new File(file).createNewFile();
    }
}
