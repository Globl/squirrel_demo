package com.zdsoft.littleapple.http.okhttp;

/**
 * Created by TUJH on 2016/2/19.
 */
public interface UploadRequestListener {

    void onRequestUpload(long bytesWritten, long contentLength, boolean done);

}
