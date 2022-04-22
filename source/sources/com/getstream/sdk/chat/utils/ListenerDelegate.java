package com.getstream.sdk.chat.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B6\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012'\u0010\u0005\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u000bJ$\u0010\u000e\u001a\u00028\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002¢\u0006\u0002\u0010\u0012J,\u0010\u0013\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0016R\u0010\u0010\n\u001a\u00028\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0017"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/ListenerDelegate;", "L", "", "Lkotlin/properties/ReadWriteProperty;", "initialValue", "wrap", "Lkotlin/Function1;", "Lkotlin/Function0;", "Lkotlin/ParameterName;", "name", "realListener", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Object;", "wrapper", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ListenerDelegate.kt */
public final class ListenerDelegate<L> implements ReadWriteProperty<Object, L> {
    /* access modifiers changed from: private */
    public L realListener;
    private final L wrapper;

    public ListenerDelegate(L l, Function1<? super Function0<? extends L>, ? extends L> function1) {
        Intrinsics.checkNotNullParameter(l, "initialValue");
        Intrinsics.checkNotNullParameter(function1, "wrap");
        this.realListener = l;
        this.wrapper = function1.invoke(new ListenerDelegate$wrapper$1(this));
    }

    public L getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return this.wrapper;
    }

    public void setValue(Object obj, KProperty<?> kProperty, L l) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(l, "value");
        this.realListener = l;
    }
}
