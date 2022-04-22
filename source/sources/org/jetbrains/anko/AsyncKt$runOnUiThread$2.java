package org.jetbrains.anko;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 1, 5})
/* compiled from: Async.kt */
public final class AsyncKt$runOnUiThread$2 implements Runnable {

    /* renamed from: $f */
    final /* synthetic */ Function0 f489$f;

    public AsyncKt$runOnUiThread$2(Function0 function0) {
        this.f489$f = function0;
    }

    public final void run() {
        this.f489$f.invoke();
    }
}
