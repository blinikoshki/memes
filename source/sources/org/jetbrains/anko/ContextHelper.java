package org.jetbrains.anko;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo26107d2 = {"Lorg/jetbrains/anko/ContextHelper;", "", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "mainThread", "Ljava/lang/Thread;", "getMainThread", "()Ljava/lang/Thread;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 1, 5})
/* compiled from: Async.kt */
final class ContextHelper {
    public static final ContextHelper INSTANCE = null;
    private static final Handler handler = null;
    private static final Thread mainThread = null;

    static {
        new ContextHelper();
    }

    private ContextHelper() {
        INSTANCE = this;
        handler = new Handler(Looper.getMainLooper());
        Thread thread = Looper.getMainLooper().getThread();
        Intrinsics.checkExpressionValueIsNotNull(thread, "Looper.getMainLooper().thread");
        mainThread = thread;
    }

    public final Handler getHandler() {
        return handler;
    }

    public final Thread getMainThread() {
        return mainThread;
    }
}
