package com.getstream.sdk.chat.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "L", "", "invoke", "()Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ListenerDelegate.kt */
final class ListenerDelegate$wrapper$1 extends Lambda implements Function0<L> {
    final /* synthetic */ ListenerDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListenerDelegate$wrapper$1(ListenerDelegate listenerDelegate) {
        super(0);
        this.this$0 = listenerDelegate;
    }

    public final L invoke() {
        return this.this$0.realListener;
    }
}
