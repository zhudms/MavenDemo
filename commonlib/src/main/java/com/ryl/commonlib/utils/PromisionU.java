package com.ryl.commonlib.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;

import com.ryl.commonlib.utils.PromissionResult.CheckPermissionResult;


/**
 * Created by rongyile on 2017/12/5.
 */

public class PromisionU {

    public static CheckPermissionResult checkPromissions(Activity mContext, String[] mPermissions, int requestCode) {

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
     * 只要有一个失败,则返回失败
     *
     * @param results
     * @return
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
     * 当有String[]数组传入时,请求失败时,会将请求失败的权限按照 Arraylist的形式返回
     *
     * @param results    请求结果
     * @param promission 对应的权限数组
     * @return
     */
    public static PromissionResult.PromissionRequestResult isSuccess(int[] results, String[] promission) {

        boolean isSuccess = true;
        ArrayList<String> failList = new ArrayList<String>(results.length > 12 ? 12 : results.length);//Arraylist 默认长度12

        for (int i = 0; i < results.length; i++) {

            if (results[i] == PackageManager.PERMISSION_DENIED) {

                failList.add(promission[i]);
                isSuccess = false;
            }

        }

        if (isSuccess) {
            return new PromissionResult.PromissionRequestResult(true);
        } else {
            return new PromissionResult.PromissionRequestResult(false, failList);
        }
    }


}