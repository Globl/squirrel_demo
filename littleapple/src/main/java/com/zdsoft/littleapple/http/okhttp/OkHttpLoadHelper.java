package com.zdsoft.littleapple.http.okhttp;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by TUJH on 2016/2/19.
 */
public class OkHttpLoadHelper {

    /**
     * 包装OkHttpClient，用于下载文件的回调
     *
     * @param client                   待包装的OkHttpClient
     * @param downloadResponseListener 进度回调接口
     * @return 包装后的OkHttpClient，使用clone方法返回
     */
    public static OkHttpClient addDownloadResponseListener(OkHttpClient client, final DownloadResponseListener downloadResponseListener) {
        //增加拦截器
        client.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //拦截
                Response originalResponse = chain.proceed(chain.request());
                //包装响应体并返回
                return originalResponse.newBuilder()
                        .body(new DownloadResponseBody(originalResponse.body(), downloadResponseListener))
                        .build();
            }
        });
        return client;
    }

    /**
     * 包装请求体用于上传文件的回调
     *
     * @param requestBody           请求体RequestBody
     * @param uploadRequestListener 进度回调接口
     * @return 包装后的进度回调请求体
     */
    public static UploadRequestBody addProgressRequestListener(RequestBody requestBody, UploadRequestListener uploadRequestListener) {
        //包装请求体
        return new UploadRequestBody(requestBody, uploadRequestListener);
    }

}
