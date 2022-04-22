package com.downloader.core;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DefaultExecutorSupplier implements ExecutorSupplier {
    private static final int DEFAULT_MAX_NUM_THREADS = ((Runtime.getRuntime().availableProcessors() * 2) + 1);
    private final Executor backgroundExecutor = Executors.newSingleThreadExecutor();
    private final Executor mainThreadExecutor = new MainThreadExecutor();
    private final DownloadExecutor networkExecutor = new DownloadExecutor(DEFAULT_MAX_NUM_THREADS, new PriorityThreadFactory(10));

    DefaultExecutorSupplier() {
    }

    public DownloadExecutor forDownloadTasks() {
        return this.networkExecutor;
    }

    public Executor forBackgroundTasks() {
        return this.backgroundExecutor;
    }

    public Executor forMainThreadTasks() {
        return this.mainThreadExecutor;
    }
}
