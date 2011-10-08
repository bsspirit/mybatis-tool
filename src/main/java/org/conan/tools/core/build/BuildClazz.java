package org.conan.tools.core.build;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.conan.tools.core.file.ClazzTree;
import org.conan.tools.core.file.PackageTree;
import org.conan.tools.core.model.ClazzPO;

/**
 *
 * @author Conan
 */
public class BuildClazz {

    public BuildClazz(ClazzPO po) {
        PackageTree pack = new PackageTree(po);
        ClazzTree clazz = new ClazzTree(po.getModel(), pack);

        String[] trees = clazz.getTreeFileArray();
        for (String tree : trees) {
            try {
                createClazz(tree);
            } catch (IOException ex) {
                Logger.getLogger(BuildClazz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(clazz.printTreeFile());
    }

    public static boolean createClazz(String file) throws IOException {
        File dir = new File(file);
        return dir.createNewFile();
    }
}
