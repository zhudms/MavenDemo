package com.ryl.commonlib.utils;

import java.util.ArrayList;

/**
 * Created by rongyile on 2017/12/5.
 */

public class PermissionResult {

    public static final String permissionDenied = "permission denied";

    public enum CheckPermissionResult {

        SDK_LOWER, ACCESS, FAILED
    }


    public static class PermissionRequestResult {

        public boolean isSuccess;
        ArrayList<String> failLists;

        public ArrayList<String> getFailLists() {
            return failLists;
        }

        public void setFailLists(ArrayList<String> failLists) {
            this.failLists = failLists;
        }

        public PermissionRequestResult(boolean isSuccess, ArrayList<String> lists) {
            this.isSuccess = isSuccess;
            this.failLists = lists;
        }

        public PermissionRequestResult(boolean isSuccess) {
            this.isSuccess = isSuccess;
        }
    }


}
