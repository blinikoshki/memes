package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class FirebaseRemoteConfig$$Lambda$9 implements SuccessContinuation {
    private static final FirebaseRemoteConfig$$Lambda$9 instance = new FirebaseRemoteConfig$$Lambda$9();

    private FirebaseRemoteConfig$$Lambda$9() {
    }

    public static SuccessContinuation lambdaFactory$() {
        return instance;
    }

    public Task then(Object obj) {
        return Tasks.forResult(null);
    }
}
