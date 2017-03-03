/* 
 * @(#)AlertDialogUtils.java    Created on 2011-6-2
 * Copyright (c) 2011 ZDSoft Networks, Inc. All rights reserved.
 * $Id: AlertDialogUtils.java 65429 2016-02-25 03:13:07Z tujh $
 */
package com.zdsoft.littleapple.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;

/**
 * AlertDialog工具类
 *
 * @author xuan
 * @version $Revision: 65429 $, $Date: 2016-02-25 11:13:07 +0800 (周四, 25 二月 2016) $
 */
public class AlertDialogUtils {

    /**
     * 展现简单的一个按钮的alert框，类似网页alert
     *
     * @param title
     * @param message
     * @param buttonText
     */
    public static void displayAlert(Context context, String title, String message, String buttonText) {
        if (null == context || !(context instanceof Activity)) {
            return;
        }
        final Activity activity = (Activity) context;

        AlertDialog alertDialog = new Builder(activity)
                .setPositiveButton(buttonText, new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setTitle(title).setMessage(message).create();

        if (!activity.isFinishing()) {
            alertDialog.show();
        }

    }

    /**
     * 展现简单的一个按钮的alert框，类似网页alert(可在线程中使用)
     *
     * @param context
     * @param title
     * @param message
     * @param buttonText
     * @param handler
     */
    public static void displayAlert2Handler(final Context context, final String title, final String message,
                                            final String buttonText, Handler handler) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                displayAlert(context, title, message, buttonText);
            }
        });
    }

    /**
     * 供用户选择，然后触发事件的提示框
     *
     * @param context
     * @param title           标题
     * @param message         提示文本
     * @param positiveBtnText 确定按钮文本
     * @param positionOnclick 确定按钮事件
     * @param negativeBtnText 取消按钮文本
     * @param negativeOnclick 取消按钮事件
     */
    public static void displayAlert4Choice(Context context, String title, String message, String positiveBtnText,
                                           OnClickListener positionOnclick, String negativeBtnText,
                                           OnClickListener negativeOnclick) {
        if (null == context || !(context instanceof Activity)) {
            return;
        }
        final Activity activity = (Activity) context;

        Builder builder = new Builder(activity);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);

        if (null == positionOnclick) {
            positionOnclick = new OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            };
        }
        builder.setPositiveButton(positiveBtnText, positionOnclick);

        if (null == negativeOnclick) {
            negativeOnclick = new OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            };
        }
        builder.setNegativeButton(negativeBtnText, negativeOnclick);

        if (!activity.isFinishing()) {
            builder.create().show();
        }
    }

    /**
     * 多个选择选一个
     *
     * @param context
     * @param title
     * @param cancelable
     * @param selectNames
     * @param onClickListener
     */
    public static void displayAlert4SingleChoice(final Context context, String title, boolean cancelable,
                                                 String[] selectNames, final OnClickListener onClickListener) {
        if (null == context || !(context instanceof Activity)) {
            return;
        }
        final Activity activity = (Activity) context;

        AlertDialog accountDlg = new Builder(activity).setTitle(title).setCancelable(cancelable)
                .setSingleChoiceItems(selectNames, -1, new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (null != onClickListener) {
                            onClickListener.onClick(dialog, which);
                        }

                        if (!activity.isFinishing()) {
                            dialog.dismiss();
                        }
                    }
                }).create();

        if (!activity.isFinishing()) {
            accountDlg.show();
        }
    }

    /**
     * 多个选择选一个
     *
     * @param context
     * @param title
     * @param cancelable
     * @param selectNames
     * @param onClickListener
     */
    public static void displayAlert4SingleChoice2(final Context context, String title, boolean cancelable,
                                                  String[] selectNames, final OnClickListener onClickListener) {
        if (null == context || !(context instanceof Activity)) {
            return;
        }
        final Activity activity = (Activity) context;

        AlertDialog accountDlg = new Builder(activity).setTitle(title).setCancelable(cancelable)
                .setItems(selectNames, new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (null != onClickListener) {
                            onClickListener.onClick(dialog, which);
                        }

                        if (!activity.isFinishing()) {
                            dialog.dismiss();
                        }
                    }
                }).create();

        if (!activity.isFinishing()) {
            accountDlg.show();
        }
    }

}
