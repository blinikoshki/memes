package com.giphy.sdk.analytics.threading;

import android.os.Handler;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/threading/HandlerExecutor;", "Ljava/util/concurrent/Executor;", "handler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "execute", "", "command", "Ljava/lang/Runnable;", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: HandlerExecutor.kt */
public final class HandlerExecutor implements Executor {
    private final Handler handler;

    public HandlerExecutor(Handler handler2) {
        Intrinsics.checkParameterIsNotNull(handler2, "handler");
        this.handler = handler2;
    }

    public void execute(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "command");
        this.handler.post(runnable);
    }
}
