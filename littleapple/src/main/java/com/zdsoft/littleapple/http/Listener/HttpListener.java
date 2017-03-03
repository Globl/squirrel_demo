package com.zdsoft.littleapple.http.Listener;

/**
 * Created by TUJH on 2016/5/9.
 */
public interface HttpListener<T> {

    void onResponseListener(T obj);

    void onErrorResponseListener();

}
