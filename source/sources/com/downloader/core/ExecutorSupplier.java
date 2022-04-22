package com.downloader.core;

import java.util.concurrent.Executor;

public interface ExecutorSupplier {
    Executor forBackgroundTasks();

    DownloadExecutor forDownloadTasks();

    Executor forMainThreadTasks();
}
