package org.jetbrains.anko;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "", "T", "run"}, mo26108k = 3, mo26109mv = {1, 1, 5})
/* compiled from: Async.kt */
final class AsyncKt$onComplete$1 implements Runnable {

    /* renamed from: $f */
    final /* synthetic */ Function1 f487$f;
    final /* synthetic */ Object $ref;

    AsyncKt$onComplete$1(Function1 function1, Object obj) {
        this.f487$f = function1;
        this.$ref = obj;
    }

    public final void run() {
        this.f487$f.invoke(this.$ref);
    }
}
