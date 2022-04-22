package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class ProgressiveDownloader implements Downloader {
    private final CacheDataSource dataSource;
    private final DataSpec dataSpec;
    private volatile RunnableFutureTask<Void, IOException> downloadRunnable;
    private final Executor executor;
    private volatile boolean isCanceled;
    private final PriorityTaskManager priorityTaskManager;
    private Downloader.ProgressListener progressListener;

    @Deprecated
    public ProgressiveDownloader(Uri uri, String str, CacheDataSource.Factory factory) {
        this(uri, str, factory, $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE);
    }

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, (Executor) $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE);
    }

    @Deprecated
    public ProgressiveDownloader(Uri uri, String str, CacheDataSource.Factory factory, Executor executor2) {
        this(new MediaItem.Builder().setUri(uri).setCustomCacheKey(str).build(), factory, executor2);
    }

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor2) {
        this.executor = (Executor) Assertions.checkNotNull(executor2);
        Assertions.checkNotNull(mediaItem.playbackProperties);
        this.dataSpec = new DataSpec.Builder().setUri(mediaItem.playbackProperties.uri).setKey(mediaItem.playbackProperties.customCacheKey).setFlags(4).build();
        this.dataSource = factory.createDataSourceForDownloading();
        this.priorityTaskManager = factory.getUpstreamPriorityTaskManager();
    }

    public void download(Downloader.ProgressListener progressListener2) throws IOException, InterruptedException {
        this.progressListener = progressListener2;
        if (this.downloadRunnable == null) {
            final CacheWriter cacheWriter = new CacheWriter(this.dataSource, this.dataSpec, false, (byte[]) null, new CacheWriter.ProgressListener() {
                public final void onProgress(long j, long j2, long j3) {
                    ProgressiveDownloader.this.onProgress(j, j2, j3);
                }
            });
            this.downloadRunnable = new RunnableFutureTask<Void, IOException>(this) {
                /* access modifiers changed from: protected */
                public Void doWork() throws IOException {
                    cacheWriter.cache();
                    return null;
                }

                /* access modifiers changed from: protected */
                public void cancelWork() {
                    cacheWriter.cancel();
                }
            };
        }
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        if (priorityTaskManager2 != null) {
            priorityTaskManager2.add(-1000);
        }
        boolean z = false;
        while (!z) {
            try {
                if (this.isCanceled) {
                    break;
                }
                PriorityTaskManager priorityTaskManager3 = this.priorityTaskManager;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.proceed(-1000);
                }
                this.executor.execute(this.downloadRunnable);
                this.downloadRunnable.get();
                z = true;
            } catch (ExecutionException e) {
                Throwable th = (Throwable) Assertions.checkNotNull(e.getCause());
                if (!(th instanceof PriorityTaskManager.PriorityTooLowException)) {
                    if (!(th instanceof IOException)) {
                        Util.sneakyThrow(th);
                    } else {
                        throw ((IOException) th);
                    }
                }
            } catch (Throwable th2) {
                this.downloadRunnable.blockUntilFinished();
                PriorityTaskManager priorityTaskManager4 = this.priorityTaskManager;
                if (priorityTaskManager4 != null) {
                    priorityTaskManager4.remove(-1000);
                }
                throw th2;
            }
        }
        this.downloadRunnable.blockUntilFinished();
        PriorityTaskManager priorityTaskManager5 = this.priorityTaskManager;
        if (priorityTaskManager5 != null) {
            priorityTaskManager5.remove(-1000);
        }
    }

    public void cancel() {
        this.isCanceled = true;
        RunnableFutureTask<Void, IOException> runnableFutureTask = this.downloadRunnable;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(true);
        }
    }

    public void remove() {
        this.dataSource.getCache().removeResource(this.dataSource.getCacheKeyFactory().buildCacheKey(this.dataSpec));
    }

    /* access modifiers changed from: private */
    public void onProgress(long j, long j2, long j3) {
        Downloader.ProgressListener progressListener2 = this.progressListener;
        if (progressListener2 != null) {
            progressListener2.onProgress(j, j2, (j == -1 || j == 0) ? -1.0f : (((float) j2) * 100.0f) / ((float) j));
        }
    }
}
