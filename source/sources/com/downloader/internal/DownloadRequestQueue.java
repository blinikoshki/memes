package com.downloader.internal;

import com.downloader.Status;
import com.downloader.core.Core;
import com.downloader.request.DownloadRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadRequestQueue {
    private static DownloadRequestQueue instance;
    private final Map<Integer, DownloadRequest> currentRequestMap = new ConcurrentHashMap();
    private final AtomicInteger sequenceGenerator = new AtomicInteger();

    private DownloadRequestQueue() {
    }

    public static void initialize() {
        getInstance();
    }

    public static DownloadRequestQueue getInstance() {
        if (instance == null) {
            synchronized (DownloadRequestQueue.class) {
                if (instance == null) {
                    instance = new DownloadRequestQueue();
                }
            }
        }
        return instance;
    }

    private int getSequenceNumber() {
        return this.sequenceGenerator.incrementAndGet();
    }

    public void pause(int i) {
        DownloadRequest downloadRequest = this.currentRequestMap.get(Integer.valueOf(i));
        if (downloadRequest != null) {
            downloadRequest.setStatus(Status.PAUSED);
        }
    }

    public void resume(int i) {
        DownloadRequest downloadRequest = this.currentRequestMap.get(Integer.valueOf(i));
        if (downloadRequest != null) {
            downloadRequest.setStatus(Status.QUEUED);
            downloadRequest.setFuture(Core.getInstance().getExecutorSupplier().forDownloadTasks().submit(new DownloadRunnable(downloadRequest)));
        }
    }

    private void cancelAndRemoveFromMap(DownloadRequest downloadRequest) {
        if (downloadRequest != null) {
            downloadRequest.cancel();
            this.currentRequestMap.remove(Integer.valueOf(downloadRequest.getDownloadId()));
        }
    }

    public void cancel(int i) {
        cancelAndRemoveFromMap(this.currentRequestMap.get(Integer.valueOf(i)));
    }

    public void cancel(Object obj) {
        for (Map.Entry<Integer, DownloadRequest> value : this.currentRequestMap.entrySet()) {
            DownloadRequest downloadRequest = (DownloadRequest) value.getValue();
            if (!(downloadRequest.getTag() instanceof String) || !(obj instanceof String)) {
                if (downloadRequest.getTag().equals(obj)) {
                    cancelAndRemoveFromMap(downloadRequest);
                }
            } else if (((String) downloadRequest.getTag()).equals((String) obj)) {
                cancelAndRemoveFromMap(downloadRequest);
            }
        }
    }

    public void cancelAll() {
        for (Map.Entry<Integer, DownloadRequest> value : this.currentRequestMap.entrySet()) {
            cancelAndRemoveFromMap((DownloadRequest) value.getValue());
        }
    }

    public Status getStatus(int i) {
        DownloadRequest downloadRequest = this.currentRequestMap.get(Integer.valueOf(i));
        if (downloadRequest != null) {
            return downloadRequest.getStatus();
        }
        return Status.UNKNOWN;
    }

    public void addRequest(DownloadRequest downloadRequest) {
        this.currentRequestMap.put(Integer.valueOf(downloadRequest.getDownloadId()), downloadRequest);
        downloadRequest.setStatus(Status.QUEUED);
        downloadRequest.setSequenceNumber(getSequenceNumber());
        downloadRequest.setFuture(Core.getInstance().getExecutorSupplier().forDownloadTasks().submit(new DownloadRunnable(downloadRequest)));
    }

    public void finish(DownloadRequest downloadRequest) {
        this.currentRequestMap.remove(Integer.valueOf(downloadRequest.getDownloadId()));
    }
}
