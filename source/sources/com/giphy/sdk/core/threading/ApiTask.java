package com.giphy.sdk.core.threading;

import android.os.Handler;
import android.os.Looper;
import com.giphy.sdk.core.network.api.CompletionHandler;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0011*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0011B\u0015\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005B%\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ\u000b\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/giphy/sdk/core/threading/ApiTask;", "V", "", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)V", "networkRequestExecutor", "Ljava/util/concurrent/ExecutorService;", "completionExecutor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Callable;Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/Executor;)V", "executeAsyncTask", "Ljava/util/concurrent/Future;", "completionHandler", "Lcom/giphy/sdk/core/network/api/CompletionHandler;", "executeImmediately", "()Ljava/lang/Object;", "Companion", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: ApiTask.kt */
public final class ApiTask<V> {
    /* access modifiers changed from: private */
    public static Executor COMPLETION_EXECUTOR = null;
    /* access modifiers changed from: private */
    public static final int CPU_COUNT;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static ExecutorService NETWORK_REQUEST_EXECUTOR = null;
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

    public final Future<?> executeAsyncTask(CompletionHandler<? super V> completionHandler) {
        Intrinsics.checkParameterIsNotNull(completionHandler, "completionHandler");
        Future<?> submit = this.networkRequestExecutor.submit(new ApiTask$executeAsyncTask$1(this, completionHandler));
        Intrinsics.checkExpressionValueIsNotNull(submit, "networkRequestExecutor.s…}\n            }\n        }");
        return submit;
    }

    public final V executeImmediately() throws Exception {
        return this.callable.call();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b¨\u0006\u0015"}, mo26107d2 = {"Lcom/giphy/sdk/core/threading/ApiTask$Companion;", "", "()V", "COMPLETION_EXECUTOR", "Ljava/util/concurrent/Executor;", "CPU_COUNT", "", "getCPU_COUNT", "()I", "NETWORK_REQUEST_EXECUTOR", "Ljava/util/concurrent/ExecutorService;", "THREAD_POOL_CORE_SIZE", "getTHREAD_POOL_CORE_SIZE", "THREAD_POOL_KEEP_ALIVE_TIME", "", "getTHREAD_POOL_KEEP_ALIVE_TIME", "()J", "THREAD_POOL_MAX_SIZE", "getTHREAD_POOL_MAX_SIZE", "getCompletionExecutor", "getNetworkRequestExecutor", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
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
            if (ApiTask.NETWORK_REQUEST_EXECUTOR == null) {
                Companion companion = this;
                ApiTask.NETWORK_REQUEST_EXECUTOR = new ThreadPoolExecutor(companion.getTHREAD_POOL_CORE_SIZE(), companion.getTHREAD_POOL_MAX_SIZE(), companion.getTHREAD_POOL_KEEP_ALIVE_TIME(), TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
            ExecutorService access$getNETWORK_REQUEST_EXECUTOR$cp = ApiTask.NETWORK_REQUEST_EXECUTOR;
            if (access$getNETWORK_REQUEST_EXECUTOR$cp == null) {
                Intrinsics.throwNpe();
            }
            return access$getNETWORK_REQUEST_EXECUTOR$cp;
        }

        public final Executor getCompletionExecutor() {
            if (ApiTask.COMPLETION_EXECUTOR == null) {
                ApiTask.COMPLETION_EXECUTOR = new HandlerExecutor(new Handler(Looper.getMainLooper()));
            }
            Executor access$getCOMPLETION_EXECUTOR$cp = ApiTask.COMPLETION_EXECUTOR;
            if (access$getCOMPLETION_EXECUTOR$cp == null) {
                Intrinsics.throwNpe();
            }
            return access$getCOMPLETION_EXECUTOR$cp;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        THREAD_POOL_CORE_SIZE = availableProcessors + 2;
        THREAD_POOL_MAX_SIZE = (availableProcessors * 2) + 2;
    }
}
