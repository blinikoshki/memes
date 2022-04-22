package p015io.getstream.chat.android.client.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0000¨\u0006\u0006"}, mo26107d2 = {"threadLocal", "Lkotlin/properties/ReadOnlyProperty;", "", "T", "value", "Lkotlin/Function0;", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.ThreadLocalDelegateKt */
/* compiled from: ThreadLocalDelegate.kt */
public final class ThreadLocalDelegateKt {
    public static final <T> ReadOnlyProperty<Object, T> threadLocal(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "value");
        return new ThreadLocalDelegate<>(function0);
    }
}
