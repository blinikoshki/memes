package com.memes.plus.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\f"}, mo26107d2 = {"Lcom/memes/plus/util/AppExecutors;", "", "()V", "diskIO", "Ljava/util/concurrent/Executor;", "getDiskIO", "()Ljava/util/concurrent/Executor;", "mainThread", "getMainThread", "networkIO", "getNetworkIO", "MainThreadExecutor", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AppExecutors.kt */
public final class AppExecutors {
    private final Executor diskIO;
    private final Executor mainThread = new MainThreadExecutor();
    private final Executor networkIO;

    public AppExecutors() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
        this.diskIO = newSingleThreadExecutor;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        Intrinsics.checkNotNullExpressionValue(newFixedThreadPool, "Executors.newFixedThreadPool(3)");
        this.networkIO = newFixedThreadPool;
    }

    public final Executor getDiskIO() {
        return this.diskIO;
    }

    public final Executor getNetworkIO() {
        return this.networkIO;
    }

    public final Executor getMainThread() {
        return this.mainThread;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/util/AppExecutors$MainThreadExecutor;", "Ljava/util/concurrent/Executor;", "()V", "mainThreadHandler", "Landroid/os/Handler;", "execute", "", "command", "Ljava/lang/Runnable;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: AppExecutors.kt */
    private static final class MainThreadExecutor implements Executor {
        private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "command");
            this.mainThreadHandler.post(runnable);
        }
    }
}
