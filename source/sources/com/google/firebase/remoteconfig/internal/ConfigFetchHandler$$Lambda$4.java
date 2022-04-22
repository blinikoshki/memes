package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

/* compiled from: ConfigFetchHandler */
final /* synthetic */ class ConfigFetchHandler$$Lambda$4 implements SuccessContinuation {
    private final ConfigFetchHandler.FetchResponse arg$1;

    private ConfigFetchHandler$$Lambda$4(ConfigFetchHandler.FetchResponse fetchResponse) {
        this.arg$1 = fetchResponse;
    }

    public static SuccessContinuation lambdaFactory$(ConfigFetchHandler.FetchResponse fetchResponse) {
        return new ConfigFetchHandler$$Lambda$4(fetchResponse);
    }

    public Task then(Object obj) {
        return Tasks.forResult(this.arg$1);
    }
}
