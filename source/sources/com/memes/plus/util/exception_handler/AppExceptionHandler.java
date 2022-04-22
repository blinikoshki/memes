package com.memes.plus.util.exception_handler;

import android.content.Context;
import com.jakewharton.processphoenix.ProcessPhoenix;
import com.memes.crashreporter.CrashLog;
import com.memes.crashreporter.CrashReporter;
import com.memes.plus.App;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/util/exception_handler/AppExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "uncaughtException", "", "t", "Ljava/lang/Thread;", "cause", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AppExceptionHandler.kt */
public final class AppExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final Context context;

    public AppExceptionHandler(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Intrinsics.checkNotNullParameter(thread, "t");
        Intrinsics.checkNotNullParameter(th, "cause");
        Timber.m303e("uncaughtException(" + th + ')', new Object[0]);
        try {
            CrashReporter crashReporter = App.Companion.crashReporter();
            CrashLog.Builder builder = new CrashLog.Builder(th);
            crashReporter.report(builder.addMessage("Reported By: AppExceptionHandler on thread " + thread).build());
            ProcessPhoenix.triggerRebirth(this.context);
        } catch (Exception e) {
            Timber.m303e("An exception " + e + " occurred in UncaughtExceptionHandler of " + th, new Object[0]);
        }
    }
}
