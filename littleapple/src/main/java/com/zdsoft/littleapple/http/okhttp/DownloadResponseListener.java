package com.zdsoft.littleapple.http.okhttp;

/**
 * Created by TUJH on 2016/2/19.
 */
public interface DownloadResponseListener {

    void onResponseDownload(long bytesRead, long contentLength, boolean done);

}
