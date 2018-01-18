package com.ryl.commonlib.values;

/**
 * Created by rongyile on 2018/1/18.
 */

public class IsOnDebug {

    public static boolean isDebug = true;

    public static boolean isIsDebug() {
        return isDebug;
    }

    public static void setIsDebug(boolean isDebug) {
        IsOnDebug.isDebug = isDebug;
    }
}
