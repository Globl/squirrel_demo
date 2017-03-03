package com.zdsoft.littleapple.db.exception;

/**
 * 自定义的一个数据库操作异常
 * 
 * @author xuan
 * @version $Revision: 65429 $, $Date: 2016-02-25 11:13:07 +0800 (周四, 25 二月 2016) $
 */
public class DbException extends Exception {
    private static final long serialVersionUID = -1287845410412219321L;

    public DbException() {
    }

    public DbException(String message) {
        super(message);
    }

    public DbException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DbException(Throwable throwable) {
        super(throwable);
    }

}
