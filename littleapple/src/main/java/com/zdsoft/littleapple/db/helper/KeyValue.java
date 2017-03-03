package com.zdsoft.littleapple.db.helper;

/**
 * 对象属性的键值对
 * 
 * @author xuan
 * @version $Revision: 65429 $, $Date: 2016-02-25 11:13:07 +0800 (周四, 25 二月 2016) $
 */
public class KeyValue {
    public final String key;
    public final Object value;

    public KeyValue(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}
