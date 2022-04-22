package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class FirebaseRemoteConfig$$Lambda$10 implements Continuation {
    private final FirebaseRemoteConfig arg$1;

    private FirebaseRemoteConfig$$Lambda$10(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.arg$1 = firebaseRemoteConfig;
    }

    public static Continuation lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new FirebaseRemoteConfig$$Lambda$10(firebaseRemoteConfig);
    }

    public Object then(Task task) {
        return Boolean.valueOf(this.arg$1.processActivatePutTask(task));
    }
}
