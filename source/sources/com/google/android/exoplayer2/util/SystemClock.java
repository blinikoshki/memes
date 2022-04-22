package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;

public class SystemClock implements Clock {
    protected SystemClock() {
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    public long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }

    public void sleep(long j) {
        android.os.SystemClock.sleep(j);
    }

    public HandlerWrapper createHandler(Looper looper, Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }
}
