package com.getstream.sdk.chat.view;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModelBinding.kt */
final class MessageListViewModelBinding$sam$androidx_lifecycle_Observer$0 implements Observer {
    private final /* synthetic */ Function1 function;

    MessageListViewModelBinding$sam$androidx_lifecycle_Observer$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ void onChanged(Object obj) {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
