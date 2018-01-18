package com.ryl.commonlib.utils;

import android.content.Context;
import android.widget.Toast;

import com.ryl.commonlib.values.IsOnDebug;

/**
 * Created by TANG on 2016/3/14.
 */
public class ToastU {

    public static void toast(Context mContext, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }


    public static void toast(Context mContext, int message) {
        Toast.makeText(mContext, mContext.getResources().getString(message), Toast.LENGTH_SHORT).show();
    }

    public static void ht(Context mContext, String message) {

        if (IsOnDebug.isDebug){
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        }

    }



}
