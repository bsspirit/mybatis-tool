package org.conan.base.util;

public final class MyCast {

    /**
     * 转换字符串到整形
     * 
     * @param s 转换的字符串
     * @param def 输出的默认值
     */
    public static int string2Int(String s, int def) {
        int tmp = def;
        if (s != null && !s.equals("")) {
            try {
                tmp = Integer.parseInt(s);
            } catch (Exception e) {
            }
        }
        return tmp;
    }

}
