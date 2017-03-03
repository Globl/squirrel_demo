package com.zdsoft.littleapple.utils.display;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;

/**
 * 屏幕显示工具类
 *
 * @author xuan
 * @version $Revision: 65429 $, $Date: 2016-02-25 11:13:07 +0800 (周四, 25 二月 2016) $
 */
public abstract class DisplayUtils {

    /**
     * 返回屏幕参数值，其中含：density、scaledDensity、densityDpi、heightPixels、widthPixels、
     * xdpi、ydpi<br>
     * <p/>
     * density:在分辨率是320*480的手机上该值是：1.0<br>
     * scaledDensity：在分辨率是320*480的手机上该值是：1.0（针对字体）<br>
     * densityDpi：在分辨率是320*480的手机上该值是：160（表示每英寸px像素点）<br>
     * heightPixels和widthPixels：分别表示屏幕的高和宽，单位px<br>
     * xdpi和ydpi：分别表示屏幕的x方向和y方向的dp值<br>
     *
     * @param activity
     * @return
     */
    public static DisplayMetrics getDisplayMetrics(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

    /**
     * dp转成px（也可以使用SDK自带的TypedValue工具类）
     *
     * @param activity
     * @param dpValue
     * @return
     */
    public static float getPxByDp(Activity activity, float dpValue) {
        return dpValue * getDisplayMetrics(activity).density;
    }

    /**
     * px转成dp
     *
     * @param activity
     * @param pxValue
     * @return
     */
    public static float getDpByPx(Activity activity, float pxValue) {
        return pxValue / getDisplayMetrics(activity).density;
    }

    /**
     * sp转成px
     *
     * @param activity
     * @param spValue
     * @return
     */
    public static float getPxBySp(Activity activity, float spValue) {
        return spValue * getDisplayMetrics(activity).scaledDensity;
    }

    /**
     * px转成sp
     *
     * @param activity
     * @param pxValue
     * @return
     */
    public static float getSpByPx(Activity activity, float pxValue) {
        return pxValue / getDisplayMetrics(activity).scaledDensity;
    }


    /**
     * 获取状态栏高度 *  * @return
     */
    public static int[] getStatusBarHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int statusBarHeight = rect.top;
        // 状态栏高度
        int bottomHeight = rect.bottom;
        // 底部虚拟键盘的
        return new int[]{statusBarHeight, bottomHeight};
    }
}
