package org.conan.tools.util.match;

import java.util.Random;

public class RandomUtil {

    private static Random ran = new Random();

    private RandomUtil() {
    }

    public static int nextInt(int size) {
        if (ran == null) {
            ran = new Random();
        }
        return ran.nextInt(size);
    }

}
