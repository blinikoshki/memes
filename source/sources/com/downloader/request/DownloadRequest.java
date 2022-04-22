package com.downloader.request;

import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.Priority;
import com.downloader.Response;
import com.downloader.Status;
import com.downloader.core.Core;
import com.downloader.internal.ComponentHolder;
import com.downloader.internal.DownloadRequestQueue;
import com.downloader.internal.SynchronousCall;
import com.downloader.utils.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;

public class DownloadRequest {
    private int connectTimeout;
    private String dirPath;
    private int downloadId;
    private long downloadedBytes;
    private String fileName;
    private Future future;
    private HashMap<String, List<String>> headerMap;
    /* access modifiers changed from: private */
    public OnCancelListener onCancelListener;
    /* access modifiers changed from: private */
    public OnDownloadListener onDownloadListener;
    /* access modifiers changed from: private */
    public OnPauseListener onPauseListener;
    private OnProgressListener onProgressListener;
    /* access modifiers changed from: private */
    public OnStartOrResumeListener onStartOrResumeListener;
    private Priority priority;
    private int readTimeout;
    private int sequenceNumber;
    private Status status;
    private Object tag;
    private long totalBytes;
    private String url;
    private String userAgent;

    DownloadRequest(DownloadRequestBuilder downloadRequestBuilder) {
        int i;
        int i2;
        this.url = downloadRequestBuilder.url;
        this.dirPath = downloadRequestBuilder.dirPath;
        this.fileName = downloadRequestBuilder.fileName;
        this.headerMap = downloadRequestBuilder.headerMap;
        this.priority = downloadRequestBuilder.priority;
        this.tag = downloadRequestBuilder.tag;
        if (downloadRequestBuilder.readTimeout != 0) {
            i = downloadRequestBuilder.readTimeout;
        } else {
            i = getReadTimeoutFromConfig();
        }
        this.readTimeout = i;
        if (downloadRequestBuilder.connectTimeout != 0) {
            i2 = downloadRequestBuilder.connectTimeout;
        } else {
            i2 = getConnectTimeoutFromConfig();
        }
        this.connectTimeout = i2;
        this.userAgent = downloadRequestBuilder.userAgent;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(Priority priority2) {
        this.priority = priority2;
    }

    public Object getTag() {
        return this.tag;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getDirPath() {
        return this.dirPath;
    }

    public void setDirPath(String str) {
        this.dirPath = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public void setSequenceNumber(int i) {
        this.sequenceNumber = i;
    }

    public HashMap<String, List<String>> getHeaders() {
        return this.headerMap;
    }

    public Future getFuture() {
        return this.future;
    }

    public void setFuture(Future future2) {
        this.future = future2;
    }

    public long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public void setDownloadedBytes(long j) {
        this.downloadedBytes = j;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public String getUserAgent() {
        if (this.userAgent == null) {
            this.userAgent = ComponentHolder.getInstance().getUserAgent();
        }
        return this.userAgent;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public int getDownloadId() {
        return this.downloadId;
    }

    public void setDownloadId(int i) {
        this.downloadId = i;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status2) {
        this.status = status2;
    }

    public OnProgressListener getOnProgressListener() {
        return this.onProgressListener;
    }

    public DownloadRequest setOnStartOrResumeListener(OnStartOrResumeListener onStartOrResumeListener2) {
        this.onStartOrResumeListener = onStartOrResumeListener2;
        return this;
    }

    public DownloadRequest setOnProgressListener(OnProgressListener onProgressListener2) {
        this.onProgressListener = onProgressListener2;
        return this;
    }

    public DownloadRequest setOnPauseListener(OnPauseListener onPauseListener2) {
        this.onPauseListener = onPauseListener2;
        return this;
    }

    public DownloadRequest setOnCancelListener(OnCancelListener onCancelListener2) {
        this.onCancelListener = onCancelListener2;
        return this;
    }

    public int start(OnDownloadListener onDownloadListener2) {
        this.onDownloadListener = onDownloadListener2;
        this.downloadId = Utils.getUniqueId(this.url, this.dirPath, this.fileName);
        DownloadRequestQueue.getInstance().addRequest(this);
        return this.downloadId;
    }

    public Response executeSync() {
        this.downloadId = Utils.getUniqueId(this.url, this.dirPath, this.fileName);
        return new SynchronousCall(this).execute();
    }

    public void deliverError(final Error error) {
        if (this.status != Status.CANCELLED) {
            setStatus(Status.FAILED);
            Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() {
                public void run() {
                    if (DownloadRequest.this.onDownloadListener != null) {
                        DownloadRequest.this.onDownloadListener.onError(error);
                    }
                    DownloadRequest.this.finish();
                }
            });
        }
    }

    public void deliverSuccess() {
        if (this.status != Status.CANCELLED) {
            setStatus(Status.COMPLETED);
            Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() {
                public void run() {
                    if (DownloadRequest.this.onDownloadListener != null) {
                        DownloadRequest.this.onDownloadListener.onDownloadComplete();
                    }
                    DownloadRequest.this.finish();
                }
            });
        }
    }

    public void deliverStartEvent() {
        if (this.status != Status.CANCELLED) {
            Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() {
                public void run() {
                    if (DownloadRequest.this.onStartOrResumeListener != null) {
                        DownloadRequest.this.onStartOrResumeListener.onStartOrResume();
                    }
                }
            });
        }
    }

    public void deliverPauseEvent() {
        if (this.status != Status.CANCELLED) {
            Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() {
                public void run() {
                    if (DownloadRequest.this.onPauseListener != null) {
                        DownloadRequest.this.onPauseListener.onPause();
                    }
                }
            });
        }
    }

    private void deliverCancelEvent() {
        Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() {
            public void run() {
                if (DownloadRequest.this.onCancelListener != null) {
                    DownloadRequest.this.onCancelListener.onCancel();
                }
            }
        });
    }

    public void cancel() {
        this.status = Status.CANCELLED;
        Future future2 = this.future;
        if (future2 != null) {
            future2.cancel(true);
        }
        deliverCancelEvent();
        Utils.deleteTempFileAndDatabaseEntryInBackground(Utils.getTempPath(this.dirPath, this.fileName), this.downloadId);
    }

    /* access modifiers changed from: private */
    public void finish() {
        destroy();
        DownloadRequestQueue.getInstance().finish(this);
    }

    private void destroy() {
        this.onProgressListener = null;
        this.onDownloadListener = null;
        this.onStartOrResumeListener = null;
        this.onPauseListener = null;
        this.onCancelListener = null;
    }

    private int getReadTimeoutFromConfig() {
        return ComponentHolder.getInstance().getReadTimeout();
    }

    private int getConnectTimeoutFromConfig() {
        return ComponentHolder.getInstance().getConnectTimeout();
    }
}
