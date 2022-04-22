package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Date;

/* compiled from: ConfigFetchHandler */
final /* synthetic */ class ConfigFetchHandler$$Lambda$2 implements Continuation {
    private final ConfigFetchHandler arg$1;
    private final Task arg$2;
    private final Task arg$3;
    private final Date arg$4;

    private ConfigFetchHandler$$Lambda$2(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date) {
        this.arg$1 = configFetchHandler;
        this.arg$2 = task;
        this.arg$3 = task2;
        this.arg$4 = date;
    }

    public static Continuation lambdaFactory$(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date) {
        return new ConfigFetchHandler$$Lambda$2(configFetchHandler, task, task2, date);
    }

    public Object then(Task task) {
        return ConfigFetchHandler.lambda$fetchIfCacheExpiredAndNotThrottled$1(this.arg$1, this.arg$2, this.arg$3, this.arg$4, task);
    }
}
