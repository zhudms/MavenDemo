package com.ryl.commonlib.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;

/**
 * Created by rongyile on 2018/1/31.
 */

public class BitmapU {

    public static final int TAG_FREE = -1;

    /**
     *
     * didn't take care of oom
     * @param resource yuanshuju
     * @param tagWidth 目标宽度
     * @param tagHeight 目标高度
     * @return 变换后的数据
     */
    public static Bitmap getTagSizeBitmap(Bitmap resource, int tagWidth, int tagHeight) {


        if (resource == null || tagHeight == TAG_FREE && tagWidth == TAG_FREE) {
            return null;
        }


        if (tagHeight == TAG_FREE) {
            int width = resource.getWidth();
            int height = resource.getHeight();

            double scal = tagWidth / (float) width;

            tagHeight = (int) (height * scal);
        }


        if (tagWidth == TAG_FREE) {
            int width = resource.getWidth();
            int height = resource.getHeight();

            double scal = tagHeight / (float) height;
            tagWidth = (int) (width * scal);
        }

        Bitmap bitmap = Bitmap.createScaledBitmap(resource, (int) tagWidth, (int) tagHeight, false);

        return bitmap;
    }


    public static Bitmap getWinWidthBitmap(Context context, Bitmap bitmap) {
        Point p = WindowU.getWindowMessage(context);
        return getTagSizeBitmap(bitmap, p.x,TAG_FREE);
    }



}
