package com.getstream.sdk.chat.utils.extensions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\bø\u0001\u0000\u001a \u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0006"}, mo26107d2 = {"whenFalse", "", "f", "Lkotlin/Function0;", "", "whenTrue", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Primitives.kt */
public final class PrimitivesKt {
    public static final boolean whenTrue(boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "f");
        if (z) {
            function0.invoke();
        }
        return z;
    }

    public static final boolean whenFalse(boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "f");
        if (!z) {
            function0.invoke();
        }
        return z;
    }
}
