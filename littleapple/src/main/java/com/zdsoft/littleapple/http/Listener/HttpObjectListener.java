package com.zdsoft.littleapple.http.Listener;

/**
 * Created by TUJH on 2016/5/9.
 */
public interface HttpObjectListener<T> {

    void onResponseListener(T obj, Object... objects);

    void onErrorResponseListener();

}
