package com.ryl.commonlib.tools;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by rongyile on 2018/1/3.
 */

public class StringUtils {

    public static final String getString(Context context,int resourceID){

        if (context==null){
            return "";
        }

        return  context.getString(resourceID);
    }
}
