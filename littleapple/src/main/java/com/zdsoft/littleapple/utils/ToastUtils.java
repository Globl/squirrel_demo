/* 
 * @(#)ToastUtils.java    Created on 2011-5-31
 * Copyright (c) 2011 ZDSoft Networks, Inc. All rights reserved.
 * $Id: ToastUtils.java 66149 2016-04-27 09:08:27Z tujh $
 */
package com.zdsoft.littleapple.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public abstract class ToastUtils {

    private static Toast toast;

    /**
     * 显示吐司信息（较长时间）
     *
     * @param context 上下文
     * @param text    要提示的文本
     */
    public static void displayTextLong(final Context context, final String text) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (toast == null) {
                    toast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_LONG);
                } else {
                    toast.setText(text);
                }
                toast.show();
            }
        });
    }

    /**
     * 显示吐司信息（较短时间），可以在任意的线程中调用
     *
     * @param context 上下文
     * @param text    要提示的文本
     */
    public static void displayTextShort(final Context context, final String text) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (toast == null) {
                    toast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
                } else {
                    toast.setText(text);
                }
                toast.show();
            }
        });
    }

}
