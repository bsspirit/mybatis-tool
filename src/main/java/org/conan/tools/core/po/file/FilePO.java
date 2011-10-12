/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.conan.tools.core.po.file;

import java.util.HashMap;
import java.util.Map;

import org.conan.tools.core.po.CopyRight;
import org.conan.tools.util.match.DateMatch;
import org.conan.tools.util.match.RandomUtil;

/**
 * 
 * @author conan
 */
abstract public class FilePO {

    protected String root;

    public FilePO() {
    }

    public FilePO(String root) {
        this.root = root;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    abstract public void create();

    protected Map<String, Object> getVMMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", DateMatch.getNowDate());
        map.put("author", CopyRight.AUTHOR);
        map.put("copyright", CopyRight.COPYRIGHT);
        map.put("timestamp", System.currentTimeMillis() + "" + RandomUtil.nextInt(3) + "L");
        return map;
    }
}
