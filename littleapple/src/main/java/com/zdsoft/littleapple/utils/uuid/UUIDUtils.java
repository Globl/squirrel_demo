/* 
 * @(#)UUIDUtils.java    Created on 2012-9-28
 * Copyright (c) 2012 ZDSoft Networks, Inc. All rights reserved.
 * $Id: UUIDUtils.java 65429 2016-02-25 03:13:07Z tujh $
 */
package com.zdsoft.littleapple.utils.uuid;

/**
 * 随机串号生成
 * 
 * @author xuan
 * @version $Revision: 65429 $, $Date: 2016-02-25 11:13:07 +0800 (周四, 25 二月 2016) $
 */
public abstract class UUIDUtils {

    /**
     * 生成32位的uuid字符串
     * 
     * @return 32位的uuid字符串
     */
    public static String createId() {
        return UUIDGenerator.generateHex();
    }

}
