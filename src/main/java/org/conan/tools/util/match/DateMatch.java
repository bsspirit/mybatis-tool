package org.conan.tools.util.match;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Conan
 */
public class DateMatch {

    public final static String MY_DATE = "yyyy-MM-dd";
    public final static String MY_TIME = "HH:mm:ss";
    public final static String MY_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static String getNowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(MY_DATE);
        return sdf.format(new Date());
    }

    public static String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(MY_TIME);
        return sdf.format(new Date());
    }

    public static String getNowDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(MY_DATE_TIME);
        return sdf.format(new Date());
    }
}
