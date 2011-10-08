package org.conan.tools.core.build;

import java.io.File;
import org.conan.tools.core.file.PackageTree;
import org.conan.tools.core.model.PackagePO;

/**
 *
 * @author Conan
 */
public class BuildPackage {

    public BuildPackage(PackagePO po) {
        PackageTree pack = new PackageTree(po);

        String[] trees = pack.getTreeFolderArray();
        for (String tree : trees) {
            createPackage(tree);
        }
        System.out.println(pack.printTreeFolder());

    }

    public static boolean createPackage(String folder) {
        File dir = new File(folder);
        return dir.mkdirs();
    }
}
