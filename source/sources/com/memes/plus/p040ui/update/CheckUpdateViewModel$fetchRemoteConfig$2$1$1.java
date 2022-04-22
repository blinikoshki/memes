package com.memes.plus.p040ui.update;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "task", "Lcom/google/android/gms/tasks/Task;", "", "kotlin.jvm.PlatformType", "onComplete"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.update.CheckUpdateViewModel$fetchRemoteConfig$2$1$1 */
/* compiled from: CheckUpdateViewModel.kt */
final class CheckUpdateViewModel$fetchRemoteConfig$2$1$1<TResult> implements OnCompleteListener<Boolean> {
    final /* synthetic */ Continuation $continuation;

    CheckUpdateViewModel$fetchRemoteConfig$2$1$1(Continuation continuation) {
        this.$continuation = continuation;
    }

    public final void onComplete(Task<Boolean> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            Timber.m300d("remote-config updated: " + task.getResult(), new Object[0]);
        } else {
            Timber.m303e("remote-config failed to update", new Object[0]);
        }
        Continuation continuation = this.$continuation;
        Boolean valueOf = Boolean.valueOf(task.isSuccessful());
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1029constructorimpl(valueOf));
    }
}
