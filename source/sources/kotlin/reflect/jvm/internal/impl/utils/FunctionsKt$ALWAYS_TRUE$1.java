package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: functions.kt */
final class FunctionsKt$ALWAYS_TRUE$1 extends Lambda implements Function1<Object, Boolean> {
    public static final FunctionsKt$ALWAYS_TRUE$1 INSTANCE = new FunctionsKt$ALWAYS_TRUE$1();

    FunctionsKt$ALWAYS_TRUE$1() {
        super(1);
    }

    public final boolean invoke(Object obj) {
        return true;
    }
}
