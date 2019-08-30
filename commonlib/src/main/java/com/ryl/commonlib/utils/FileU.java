package com.ryl.commonlib.utils;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;

/**
 * �����ж϶�дȨ��,��ҪӦ����ǰ���Ȩ��
 * Created by rongyile on 2018/2/1.
 */

public class FileU {


    /**
     * ��ȡsd��·��
     *
     * @return SD ����Ŀ¼
     */
    public static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED); //�ж�sd���Ƿ����
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//��ȡ��Ŀ¼
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
     * ��ȡ�ļ���С(ֻ���ļ�,,���ļ����ļ���ʱ,����0)
     *
     * @param path �ļ�·��
     * @return �ļ���С
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
