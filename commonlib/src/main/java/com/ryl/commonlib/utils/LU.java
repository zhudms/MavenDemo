package com.ryl.commonlib.utils;

import android.support.v4.BuildConfig;
import android.util.Log;

import com.apkfuns.logutils.LogUtils;


/**
 * Created by TANG on 2016/3/14.
 */
public class LU {

    public static void hd(String tag, String message) {

        if (IsOnDebug.isDebug) {
            Log.e(tag, message);
        }

    }

    public static void he(String tag, String message) {

        if (IsOnDebug.isDebug) {
            Log.e(tag, message);
        }

    }

    public static void hw(String tag, String message) {

        if (IsOnDebug.isDebug) {
            Log.w(tag, message);
        }

    }


    public static void he(Object obj) {

        if (IsOnDebug.isDebug) {
            LogUtils.e(obj);
        }

    }


    public static void hw(Object obj) {

        if (IsOnDebug.isDebug) {
            LogUtils.w(obj);
        }

    }
}
