package p015io.getstream.chat.android.client.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J$\u0010\n\u001a\u00028\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0002\u0010\u000eR\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/ThreadLocalDelegate;", "T", "", "Lkotlin/properties/ReadOnlyProperty;", "value", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "threadLocal", "io/getstream/chat/android/client/utils/ThreadLocalDelegate$threadLocal$1", "Lio/getstream/chat/android/client/utils/ThreadLocalDelegate$threadLocal$1;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.ThreadLocalDelegate */
/* compiled from: ThreadLocalDelegate.kt */
public final class ThreadLocalDelegate<T> implements ReadOnlyProperty<Object, T> {
    private final ThreadLocalDelegate$threadLocal$1 threadLocal = new ThreadLocalDelegate$threadLocal$1(this);
    /* access modifiers changed from: private */
    public final Function0<T> value;

    public ThreadLocalDelegate(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "value");
        this.value = function0;
    }

    public T getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        T t = this.threadLocal.get();
        Intrinsics.checkNotNull(t);
        return t;
    }
}
