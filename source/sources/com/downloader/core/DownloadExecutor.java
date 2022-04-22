package com.downloader.core;

import com.downloader.internal.DownloadRunnable;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DownloadExecutor extends ThreadPoolExecutor {
    DownloadExecutor(int i, ThreadFactory threadFactory) {
        super(i, i, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), threadFactory);
    }

    public Future<?> submit(Runnable runnable) {
        DownloadFutureTask downloadFutureTask = new DownloadFutureTask((DownloadRunnable) runnable);
        execute(downloadFutureTask);
        return downloadFutureTask;
    }
}
