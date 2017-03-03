package com.zdsoft.littleapple.http.okhttp;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * Created by TUJH on 2016/2/19.
 */
public class DownloadResponseBody extends ResponseBody {

    //实际的待包装响应体
    private ResponseBody mResponseBody;
    //进度回调接口
    private DownloadResponseListener mDownloadResponseListener;
    //包装完成的BufferedSource
    private BufferedSource mBufferedSource;

    public DownloadResponseBody(ResponseBody responseBody, DownloadResponseListener downloadResponseListener) {
        this.mResponseBody = responseBody;
        this.mDownloadResponseListener = downloadResponseListener;
    }

    @Override
    public MediaType contentType() {
        return mResponseBody.contentType();
    }

    @Override
    public long contentLength() throws IOException {
        return mResponseBody.contentLength();
    }

    @Override
    public BufferedSource source() throws IOException {
        if (mBufferedSource == null) {
            mBufferedSource = Okio.buffer(source(mResponseBody.source()));
        }
        return mBufferedSource;
    }

    /**
     * 读取，回调进度接口
     *
     * @param source Source
     * @return Source
     */
    private Source source(Source source) {

        return new ForwardingSource(source) {
            //当前读取字节数
            long totalBytesRead = 0L;

            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                //增加当前读取的字节数，如果读取完成了bytesRead会返回-1
                totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                //回调，如果contentLength()不知道长度，会返回-1
                mDownloadResponseListener.onResponseDownload(totalBytesRead, mResponseBody.contentLength(), bytesRead == -1);
                return bytesRead;
            }
        };
    }
}
