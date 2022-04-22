package org.jetbrains.anko;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "throwable", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 5})
/* compiled from: Async.kt */
final class AsyncKt$crashLogger$1 extends Lambda implements Function1<Throwable, Unit> {
    public static final AsyncKt$crashLogger$1 INSTANCE = new AsyncKt$crashLogger$1();

    AsyncKt$crashLogger$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        th.printStackTrace();
    }
}
