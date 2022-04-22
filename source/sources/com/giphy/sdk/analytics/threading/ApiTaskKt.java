package com.giphy.sdk.analytics.threading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0004"}, mo26107d2 = {"COMPLETION_EXECUTOR", "Ljava/util/concurrent/Executor;", "NETWORK_REQUEST_EXECUTOR", "Ljava/util/concurrent/ExecutorService;", "giphy-android-sdk-analytics_release"}, mo26108k = 2, mo26109mv = {1, 1, 13})
/* compiled from: ApiTask.kt */
public final class ApiTaskKt {
    /* access modifiers changed from: private */
    public static Executor COMPLETION_EXECUTOR;
    /* access modifiers changed from: private */
    public static ExecutorService NETWORK_REQUEST_EXECUTOR;

    public static final /* synthetic */ Executor access$getCOMPLETION_EXECUTOR$p() {
        Executor executor = COMPLETION_EXECUTOR;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("COMPLETION_EXECUTOR");
        }
        return executor;
    }

    public static final /* synthetic */ ExecutorService access$getNETWORK_REQUEST_EXECUTOR$p() {
        ExecutorService executorService = NETWORK_REQUEST_EXECUTOR;
        if (executorService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("NETWORK_REQUEST_EXECUTOR");
        }
        return executorService;
    }
}
