package com.zdsoft.littleapple.http.Listener;

/**
 * Created by TUJH on 2017/1/4.
 */

public abstract class HttpListenerPages<T> implements HttpListener<T> {

    public int allPages;

    @Override
    public void onResponseListener(T obj) {

    }

    @Override
    public void onErrorResponseListener() {

    }
}
