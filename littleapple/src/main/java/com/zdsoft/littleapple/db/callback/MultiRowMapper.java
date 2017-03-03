/* 
 * @(#)MultiRowMapper.java    Created on 2004-12-3
 * Copyright (c) 2004 ZDSoft Networks, Inc. All rights reserved.
 * $Id: MultiRowMapper.java 65429 2016-02-25 03:13:07Z tujh $
 */
package com.zdsoft.littleapple.db.callback;

import java.sql.SQLException;

import android.database.Cursor;

/**
 * 用来处理多行记录集的情况的接口
 * 
 * @author xuan
 * @version $Revision: 65429 $, $Date: 2016-02-25 11:13:07 +0800 (周四, 25 二月 2016) $
 */
public interface MultiRowMapper<T> {
    /**
     * 把结果集的一行记录映射成一个实体对象，方法里不需要执行 <code>rs.next()</code>。
     * 
     * @param rs
     *            结果集
     * @param rowNum
     *            第几条记录，从1开始
     * @return 实体对象
     * @throws SQLException
     *             在数据库发生错误时抛出此异常
     */
    T mapRow(Cursor rs, int rowNum) throws SQLException;

}
