package com.ryl.commonlib.utils;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;

/**
 * 不会判断读写权限,需要应用提前检查权限
 * Created by rongyile on 2018/2/1.
 */

public class FileU {


    /**
     * 获取sd卡路径
     *
     * @return SD 卡根目录
     */
    public static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED); //判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        } else {
            return null;
        }
        return sdDir.toString();
    }


    public static boolean isFileExits(String path) {

        if (TextUtils.isEmpty(path)) {
            return false;
        }

        File file = new File(path);

        if (file.exists()) {
            return true;
        }

        return false;
    }


    public static boolean isFloder(String path) {

        if (isFileExits(path)) {
            File file = new File(path);
            if (file.isDirectory()) {
                return true;
            }
        }

        return false;
    }

    /**
     * 获取文件大小(只是文件,,当文件是文件夹时,返回0)
     *
     * @param path 文件路径
     * @return 文件大小
     */
    public static double getFileLength(String path) {
        if (isFloder(path)) {
            return 0;
        } else {
            File file = new File(path);
            return file.length();
        }
    }

}
