package com.giphy.sdk.analytics.threading;

import android.os.Handler;
import android.os.Looper;
import com.giphy.sdk.analytics.network.api.CompletionHandler;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0011*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0011B\u0015\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005B%\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eJ\u000b\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/threading/ApiTask;", "V", "", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)V", "networkRequestExecutor", "Ljava/util/concurrent/ExecutorService;", "completionExecutor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Callable;Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/Executor;)V", "executeAsyncTask", "Ljava/util/concurrent/Future;", "completionHandler", "Lcom/giphy/sdk/analytics/network/api/CompletionHandler;", "executeImmediately", "()Ljava/lang/Object;", "Companion", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: ApiTask.kt */
public final class ApiTask<V> {
    /* access modifiers changed from: private */
    public static final int CPU_COUNT;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int THREAD_POOL_CORE_SIZE;
    /* access modifiers changed from: private */
    public static final long THREAD_POOL_KEEP_ALIVE_TIME = 1;
    /* access modifiers changed from: private */
    public static final int THREAD_POOL_MAX_SIZE;
    /* access modifiers changed from: private */
    public final Callable<V> callable;
    /* access modifiers changed from: private */
    public final Executor completionExecutor;
    private final ExecutorService networkRequestExecutor;

    public ApiTask(Callable<V> callable2) {
        Intrinsics.checkParameterIsNotNull(callable2, "callable");
        this.callable = callable2;
        Companion companion = Companion;
        this.networkRequestExecutor = companion.getNetworkRequestExecutor();
        this.completionExecutor = companion.getCompletionExecutor();
    }

    public ApiTask(Callable<V> callable2, ExecutorService executorService, Executor executor) {
        Intrinsics.checkParameterIsNotNull(callable2, "callable");
        Intrinsics.checkParameterIsNotNull(executorService, "networkRequestExecutor");
        Intrinsics.checkParameterIsNotNull(executor, "completionExecutor");
        this.callable = callable2;
        this.networkRequestExecutor = executorService;
        this.completionExecutor = executor;
    }

    public static /* synthetic */ Future executeAsyncTask$default(ApiTask apiTask, CompletionHandler completionHandler, int i, Object obj) {
        if ((i & 1) != 0) {
            completionHandler = null;
        }
        return apiTask.executeAsyncTask(completionHandler);
    }

    public final Future<?> executeAsyncTask(CompletionHandler<V> completionHandler) {
        Future<?> submit = this.networkRequestExecutor.submit(new ApiTask$executeAsyncTask$1(this, completionHandler));
        Intrinsics.checkExpressionValueIsNotNull(submit, "networkRequestExecutor.s…}\n            }\n        }");
        return submit;
    }

    public final V executeImmediately() throws Exception {
        return this.callable.call();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0013"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/threading/ApiTask$Companion;", "", "()V", "CPU_COUNT", "", "getCPU_COUNT", "()I", "THREAD_POOL_CORE_SIZE", "getTHREAD_POOL_CORE_SIZE", "THREAD_POOL_KEEP_ALIVE_TIME", "", "getTHREAD_POOL_KEEP_ALIVE_TIME", "()J", "THREAD_POOL_MAX_SIZE", "getTHREAD_POOL_MAX_SIZE", "getCompletionExecutor", "Ljava/util/concurrent/Executor;", "getNetworkRequestExecutor", "Ljava/util/concurrent/ExecutorService;", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: ApiTask.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getCPU_COUNT() {
            return ApiTask.CPU_COUNT;
        }

        public final int getTHREAD_POOL_CORE_SIZE() {
            return ApiTask.THREAD_POOL_CORE_SIZE;
        }

        public final int getTHREAD_POOL_MAX_SIZE() {
            return ApiTask.THREAD_POOL_MAX_SIZE;
        }

        public final long getTHREAD_POOL_KEEP_ALIVE_TIME() {
            return ApiTask.THREAD_POOL_KEEP_ALIVE_TIME;
        }

        public final ExecutorService getNetworkRequestExecutor() {
            if (!(ApiTaskKt.NETWORK_REQUEST_EXECUTOR != null)) {
                Companion companion = this;
                ApiTaskKt.NETWORK_REQUEST_EXECUTOR = new ThreadPoolExecutor(companion.getTHREAD_POOL_CORE_SIZE(), companion.getTHREAD_POOL_MAX_SIZE(), companion.getTHREAD_POOL_KEEP_ALIVE_TIME(), TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
            return ApiTaskKt.access$getNETWORK_REQUEST_EXECUTOR$p();
        }

        public final Executor getCompletionExecutor() {
            if (!(ApiTaskKt.COMPLETION_EXECUTOR != null)) {
                ApiTaskKt.COMPLETION_EXECUTOR = new HandlerExecutor(new Handler(Looper.getMainLooper()));
            }
            return ApiTaskKt.access$getCOMPLETION_EXECUTOR$p();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        THREAD_POOL_CORE_SIZE = availableProcessors + 2;
        THREAD_POOL_MAX_SIZE = (availableProcessors * 2) + 2;
    }
}
