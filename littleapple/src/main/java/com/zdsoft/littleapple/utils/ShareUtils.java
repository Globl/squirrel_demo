/* 
 * @(#)ShareUtils.java    Created on 2014-7-4
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id: ShareUtils.java 65429 2016-02-25 03:13:07Z tujh $
 */
package com.zdsoft.littleapple.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.zdsoft.littleapple.utils.log.LogUtils;

import java.io.File;

/**
 * 一键分享工具类
 *
 * @author xuan
 * @version $Revision: 65429 $, $Date: 2016-02-25 11:13:07 +0800 (周四, 25 二月 2016) $
 */
public abstract class ShareUtils {

    /**
     * 分享文本内容
     *
     * @param context
     * @param subject
     * @param text
     * @param title
     */
    public static void share(Context context, String subject, String text, String title) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.putExtra(Intent.EXTRA_TITLE, title);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(Intent.createChooser(intent, "分享到"));
    }

    /**
     * 可分享图片或者文本内容
     *
     * @param context
     * @param content
     * @param uri
     */
    public static void share(Context context, String content, Uri uri) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        if (uri != null) {
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            shareIntent.setType("image/*");
        } else {
            shareIntent.setType("text/plain");
        }
        shareIntent.putExtra(Intent.EXTRA_TEXT, content);
        context.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    /**
     * 可分享图片或者文本内容
     *
     * @param context
     * @param content
     * @param fileName
     */
    public static void share(Context context, String content, String fileName) {
        if (!TextUtils.isEmpty(fileName)) {
            File file = new File(fileName);
            if (file.exists()) {
                ShareUtils.share(context, content, Uri.fromFile(file));
            } else {
                LogUtils.e("图片[" + fileName + "]不存在");
            }
        } else {
            ShareUtils.share(context, content, (Uri) null);
        }
    }

}
