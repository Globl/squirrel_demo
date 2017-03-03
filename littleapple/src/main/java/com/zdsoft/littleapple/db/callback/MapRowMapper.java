/*
 * @(#)MapRowMapper.java  1.0 2004-12-13
 * Copyright (c) 2004 ZDSoft.net, Inc. All rights reserved.
 * $Id: MapRowMapper.java 65429 2016-02-25 03:13:07Z tujh $
 */
package com.zdsoft.littleapple.db.callback;

import java.sql.ResultSet;
import java.sql.SQLException;

import android.database.Cursor;

/**
 * 此接口用于要将结果集以 Map 的形式存放的情况
 * 
 * @author xuan
 * @version $Revision: 65429 $, $Date: 2016-02-25 11:13:07 +0800 (周四, 25 二月 2016) $
 */
public interface MapRowMapper<K, V> {

    /**
     * 产生要放入 Map 中的可以标识这条记录的某个 key， 例如可以以这条记录中的某个字段的值作为 key。
     * 
     * @param rs
     *            结果集
     * @param rowNum
     *            当前记录行号
     * @return 放入 Map 的键
     */
    K mapRowKey(Cursor rs, int rowNum) throws SQLException;

    /**
     * 产生要放入 Map 中的以 {@link #mapRowKey(ResultSet, int)} 方法的返回值为 key 的某个 value。<br>
     * 例如可以以这条记录中的某个字段的值作为 value，或者一个值对象等。
     * 
     * @param rs
     *            结果集
     * @param rowNum
     *            当前记录行号
     * @return 放入 Map 的值
     */
    V mapRowValue(Cursor rs, int rowNum) throws SQLException;

}
