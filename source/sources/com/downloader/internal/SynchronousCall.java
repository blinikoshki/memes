package com.downloader.internal;

import com.downloader.Response;
import com.downloader.request.DownloadRequest;

public class SynchronousCall {
    public final DownloadRequest request;

    public SynchronousCall(DownloadRequest downloadRequest) {
        this.request = downloadRequest;
    }

    public Response execute() {
        return DownloadTask.create(this.request).run();
    }
}
