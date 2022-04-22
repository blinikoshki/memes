package com.downloader.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {
    /* access modifiers changed from: private */
    public final int mThreadPriority;

    PriorityThreadFactory(int i) {
        this.mThreadPriority = i;
    }

    public Thread newThread(final Runnable runnable) {
        return new Thread(new Runnable() {
            public void run() {
                try {
                    Process.setThreadPriority(PriorityThreadFactory.this.mThreadPriority);
                } catch (Throwable unused) {
                }
                runnable.run();
            }
        });
    }
}
