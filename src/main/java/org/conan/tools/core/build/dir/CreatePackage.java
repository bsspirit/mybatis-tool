package org.conan.tools.core.build.dir;

import java.io.File;
import java.util.List;

import org.conan.tools.core.build.PackageTree;
import org.conan.tools.core.model.PackagePO;

/**
 * 
 * @author Conan
 */
public class CreatePackage {

    public CreatePackage(PackagePO po) {
        PackageTree pack = new PackageTree(po);
        List<String> trees = pack.getTreeFile();
        for (String tree : trees) {
            new File(tree).mkdirs();
        }
        System.out.println(pack.printTreeFile());
    }
}
