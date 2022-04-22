package org.jetbrains.anko;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "T", "Landroid/app/Activity;", "run"}, mo26108k = 3, mo26109mv = {1, 1, 5})
/* compiled from: Async.kt */
final class AsyncKt$activityUiThread$2 implements Runnable {
    final /* synthetic */ Activity $activity;

    /* renamed from: $f */
    final /* synthetic */ Function1 f482$f;

    AsyncKt$activityUiThread$2(Function1 function1, Activity activity) {
        this.f482$f = function1;
        this.$activity = activity;
    }

    public final void run() {
        this.f482$f.invoke(this.$activity);
    }
}
