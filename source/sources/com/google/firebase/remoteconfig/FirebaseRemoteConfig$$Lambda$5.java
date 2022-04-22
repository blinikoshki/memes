package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class FirebaseRemoteConfig$$Lambda$5 implements SuccessContinuation {
    private static final FirebaseRemoteConfig$$Lambda$5 instance = new FirebaseRemoteConfig$$Lambda$5();

    private FirebaseRemoteConfig$$Lambda$5() {
    }

    public static SuccessContinuation lambdaFactory$() {
        return instance;
    }

    public Task then(Object obj) {
        return Tasks.forResult(null);
    }
}
