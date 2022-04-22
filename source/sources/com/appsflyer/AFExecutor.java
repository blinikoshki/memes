package com.appsflyer;

import android.net.TrafficStats;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AFExecutor {
    private static AFExecutor valueOf;
    final ThreadFactory $$a = new ThreadFactory() {
        public final Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable() {
                public final void run() {
                    TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
                    runnable.run();
                }
            });
        }
    };
    Executor $$b;
    ScheduledExecutorService AFDateFormat;
    ScheduledExecutorService values;

    private AFExecutor() {
    }

    public static AFExecutor getInstance() {
        if (valueOf == null) {
            valueOf = new AFExecutor();
        }
        return valueOf;
    }

    public Executor getThreadPoolExecutor() {
        Executor executor = this.$$b;
        if (executor == null || ((executor instanceof ThreadPoolExecutor) && (((ThreadPoolExecutor) executor).isShutdown() || ((ThreadPoolExecutor) this.$$b).isTerminated() || ((ThreadPoolExecutor) this.$$b).isTerminating()))) {
            this.$$b = Executors.newFixedThreadPool(2, this.$$a);
        }
        return this.$$b;
    }

    /* access modifiers changed from: package-private */
    public final ScheduledThreadPoolExecutor valueOf() {
        ScheduledExecutorService scheduledExecutorService = this.values;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || this.values.isTerminated()) {
            this.values = Executors.newScheduledThreadPool(2, this.$$a);
        }
        return (ScheduledThreadPoolExecutor) this.values;
    }

    static void $$b(ExecutorService executorService) {
        try {
            AFLogger.afRDLog("shut downing executor ...");
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            AFLogger.afRDLog("InterruptedException!!!");
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (Throwable th) {
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog("killing non-finished tasks");
            }
            executorService.shutdownNow();
            throw th;
        }
    }
}
