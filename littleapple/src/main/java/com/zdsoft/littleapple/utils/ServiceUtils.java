/* 
 * @(#)ServiceUtils.java    Created on 2013-3-25
 * Copyright (c) 2013 ZDSoft Networks, Inc. All rights reserved.
 * $Id: ServiceUtils.java 65429 2016-02-25 03:13:07Z tujh $
 */
package com.zdsoft.littleapple.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;

import java.util.List;

/**
 * 服务工具类
 *
 * @author xuan
 * @version $Revision: 65429 $, $Date: 2016-02-25 11:13:07 +0800 (周四, 25 二月 2016) $
 */
public class ServiceUtils {

    /**
     * 判断service是否正在运行
     *
     * @param context
     * @param className
     * @return
     */
    public static boolean isServiceRunning(Context context, String className) {
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(Integer.MAX_VALUE);

        if (serviceList.size() <= 0) {
            return false;
        }

        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }

        return isRunning;
    }

    /**
     * 启动服务，不会重复启动，但是由于检查会失去一些性能
     *
     * @param context
     * @param clazz
     * @param intent
     */
    public static void startService(Context context, Class<?> clazz, Intent intent) {
        if (!isServiceRunning(context, clazz.getName())) {
            context.startService(intent);
        }
    }

    /**
     * 关闭服务，会判断服务是否启动着，但是由于检查会失去一些性能
     *
     * @param context
     * @param clazz
     */
    public static void stopService(Context context, Class<?> clazz) {
        if (isServiceRunning(context, clazz.getName())) {
            context.stopService(new Intent(context, clazz));
        }
    }

}
