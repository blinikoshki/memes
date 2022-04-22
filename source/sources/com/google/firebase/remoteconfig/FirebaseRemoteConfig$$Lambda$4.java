package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class FirebaseRemoteConfig$$Lambda$4 implements Continuation {
    private final FirebaseRemoteConfig arg$1;
    private final Task arg$2;
    private final Task arg$3;

    private FirebaseRemoteConfig$$Lambda$4(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2) {
        this.arg$1 = firebaseRemoteConfig;
        this.arg$2 = task;
        this.arg$3 = task2;
    }

    public static Continuation lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2) {
        return new FirebaseRemoteConfig$$Lambda$4(firebaseRemoteConfig, task, task2);
    }

    public Object then(Task task) {
        return FirebaseRemoteConfig.lambda$activate$2(this.arg$1, this.arg$2, this.arg$3, task);
    }
}
