package com.ryl.commonlib.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/**
 * Created by rongyile on 2018/1/31.
 */

public class WindowU {
    public static Point getWindowMessage(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        return new Point(width, height);
    }

}
