package org.jetbrains.anko;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 1, 5})
/* compiled from: Async.kt */
final class AsyncKt$runOnUiThread$1 implements Runnable {

    /* renamed from: $f */
    final /* synthetic */ Function1 f488$f;
    final /* synthetic */ Context receiver$0;

    AsyncKt$runOnUiThread$1(Context context, Function1 function1) {
        this.receiver$0 = context;
        this.f488$f = function1;
    }

    public final void run() {
        this.f488$f.invoke(this.receiver$0);
    }
}
