package com.getstream.sdk.chat.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "p1", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModelBinding.kt */
final /* synthetic */ class MessageListViewModelBinding$bindView$10 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    MessageListViewModelBinding$bindView$10(MessageListView messageListView) {
        super(1, messageListView, MessageListView.class, "setLoadingMore", "setLoadingMore(Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        ((MessageListView) this.receiver).setLoadingMore(z);
    }
}
