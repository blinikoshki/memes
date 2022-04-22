package org.jetbrains.anko;

import android.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "T", "Landroid/app/Fragment;", "run"}, mo26108k = 3, mo26109mv = {1, 1, 5})
/* compiled from: Async.kt */
final class AsyncKt$fragmentUiThread$1 implements Runnable {

    /* renamed from: $f */
    final /* synthetic */ Function1 f485$f;
    final /* synthetic */ Fragment $fragment;

    AsyncKt$fragmentUiThread$1(Function1 function1, Fragment fragment) {
        this.f485$f = function1;
        this.$fragment = fragment;
    }

    public final void run() {
        Function1 function1 = this.f485$f;
        Fragment fragment = this.$fragment;
        Intrinsics.checkExpressionValueIsNotNull(fragment, "fragment");
        function1.invoke(fragment);
    }
}
