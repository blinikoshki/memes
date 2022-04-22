package com.downloader.core;

import com.downloader.Priority;
import com.downloader.internal.DownloadRunnable;
import java.util.concurrent.FutureTask;

public class DownloadFutureTask extends FutureTask<DownloadRunnable> implements Comparable<DownloadFutureTask> {
    private final DownloadRunnable runnable;

    DownloadFutureTask(DownloadRunnable downloadRunnable) {
        super(downloadRunnable, (Object) null);
        this.runnable = downloadRunnable;
    }

    public int compareTo(DownloadFutureTask downloadFutureTask) {
        Priority priority = this.runnable.priority;
        Priority priority2 = downloadFutureTask.runnable.priority;
        return priority == priority2 ? this.runnable.sequence - downloadFutureTask.runnable.sequence : priority2.ordinal() - priority.ordinal();
    }
}
