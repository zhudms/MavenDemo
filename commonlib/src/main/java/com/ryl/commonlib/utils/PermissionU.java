package com.ryl.commonlib.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;

import com.ryl.commonlib.utils.PermissionResult.CheckPermissionResult;


/**
 * Created by rongyile on 2017/12/5.
 */

public class PermissionU {

    public static final String SD_READ="android.permission.READ_EXTERNAL_STORAGE";
    public static final String SD_WRITE="android.permission.WRITE_EXTERNAL_STORAGE";

    public static CheckPermissionResult checkPermissions(Activity mContext, String[] mPermissions, int requestCode) {

        if (Build.VERSION.SDK_INT < 23 || mPermissions == null) {
            return CheckPermissionResult.SDK_LOWER;
        }


        for (int i = 0; i < mPermissions.length; i++) {

            if (ContextCompat.checkSelfPermission(mContext, mPermissions[i]) != PackageManager.PERMISSION_GRANTED) {
                String[] requestPromissions = Arrays.copyOfRange(mPermissions, i, mPermissions.length);
                requestThePermissions(mContext, requestPromissions, requestCode);

                return CheckPermissionResult.FAILED;

            }

        }

        return CheckPermissionResult.ACCESS;

    }

    public static void requestThePermissions(Activity mContext, String[] permissions, int mRequestCode) {
        ActivityCompat.requestPermissions(mContext, permissions, mRequestCode);
    }

    /**
     * ֻҪ��һ��ʧ��,�򷵻�ʧ��
     *
     * @param results ����Ȩ�޷��صĽ����
     * @return �Ƿ�ȫ���ɹ�
     */
    public static boolean isSuccess(int[] results) {
        for (int r : results) {
            if (r == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }

        return true;
    }

    /**
     * ����String[]���鴫��ʱ,����ʧ��ʱ,�Ὣ����ʧ�ܵ�Ȩ�ް��� Arraylist����ʽ����
     *
     * @param results    ������
     * @param promission ��Ӧ��Ȩ������
     * @return �Ƿ�ȫ������ɹ�
     */
    public static PermissionResult.PermissionRequestResult isSuccess(int[] results, String[] promission) {

        boolean isSuccess = true;
        ArrayList<String> failList = new ArrayList<String>(results.length);

        for (int i = 0; i < results.length; i++) {

            if (results[i] == PackageManager.PERMISSION_DENIED) {

                failList.add(promission[i]);
                isSuccess = false;
            }

        }

        if (isSuccess) {
            return new PermissionResult.PermissionRequestResult(true);
        } else {
            return new PermissionResult.PermissionRequestResult(false, failList);
        }
    }


}