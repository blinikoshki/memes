package com.getstream.sdk.chat.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/models/Message;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final class MessageListView$onStartThreadListener$1 extends Lambda implements Function1<Message, Unit> {
    public static final MessageListView$onStartThreadListener$1 INSTANCE = new MessageListView$onStartThreadListener$1();

    MessageListView$onStartThreadListener$1() {
        super(1);
    }

    public final void invoke(Message message) {
        Intrinsics.checkNotNullParameter(message, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Message) obj);
        return Unit.INSTANCE;
    }
}
