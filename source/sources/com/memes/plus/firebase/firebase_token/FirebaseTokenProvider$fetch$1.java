package com.memes.plus.firebase.firebase_token;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.InstallationTokenResult;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.firebase.firebase_token.FirebaseTokenProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "task", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/installations/InstallationTokenResult;", "kotlin.jvm.PlatformType", "onComplete"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FirebaseTokenProvider.kt */
final class FirebaseTokenProvider$fetch$1<TResult> implements OnCompleteListener<InstallationTokenResult> {
    final /* synthetic */ FirebaseTokenProvider.Callback $callback;
    final /* synthetic */ StorageRepository $repository;

    FirebaseTokenProvider$fetch$1(FirebaseTokenProvider.Callback callback, StorageRepository storageRepository) {
        this.$callback = callback;
        this.$repository = storageRepository;
    }

    public final void onComplete(Task<InstallationTokenResult> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            Timber.m304e(task.getException());
            FirebaseTokenProvider.Callback callback = this.$callback;
            if (callback != null) {
                callback.onResult((String) null);
                return;
            }
            return;
        }
        InstallationTokenResult result = task.getResult();
        String token = result != null ? result.getToken() : null;
        CharSequence charSequence = token;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            FirebaseTokenProvider.Callback callback2 = this.$callback;
            if (callback2 != null) {
                callback2.onResult((String) null);
                return;
            }
            return;
        }
        this.$repository.firebaseToken(token);
        FirebaseTokenProvider.Callback callback3 = this.$callback;
        if (callback3 != null) {
            callback3.onResult(token);
        }
    }
}
