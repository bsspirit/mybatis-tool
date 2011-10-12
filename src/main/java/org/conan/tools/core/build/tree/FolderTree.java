package org.conan.tools.core.build.tree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.conan.tools.util.match.StringMatch;

/**
 * 
 * @author Conan
 */
public class FolderTree extends BaseTree {

    private String root;

    public FolderTree() {
    }

    public FolderTree(String root) {
        this.root = root;
    }

    public String getRootFolder() {
        return StringMatch.transfer2Separator(root);
    }

    public String getSrcFolder() {
        return getRootFolder() + File.separator + SRC;
    }

    public String getWebFolder() {
        return getRootFolder() + File.separator + WEB;
    }

    public String getSQLFolder() {
        return getRootFolder() + File.separator + SQL;
    }

    public String getResourceFolder() {
        return getRootFolder() + File.separator + RES;
    }

    public String getTestFolder() {
        return getRootFolder() + File.separator + TEST;
    }

    @Override
    public List<String> getTreeFile() {
        List<String> tree = new ArrayList<String>();
        tree.add(getRootFolder());
        tree.add(getSrcFolder());
        tree.add(getSQLFolder());
        tree.add(getWebFolder());
        tree.add(getTestFolder());
        tree.add(getResourceFolder());
        return tree;
    }

}
