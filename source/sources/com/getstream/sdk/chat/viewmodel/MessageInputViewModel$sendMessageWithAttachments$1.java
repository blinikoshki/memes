package com.getstream.sdk.chat.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "", "Lio/getstream/chat/android/client/models/Message;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputViewModel.kt */
final class MessageInputViewModel$sendMessageWithAttachments$1 extends Lambda implements Function1<Message, Unit> {
    public static final MessageInputViewModel$sendMessageWithAttachments$1 INSTANCE = new MessageInputViewModel$sendMessageWithAttachments$1();

    MessageInputViewModel$sendMessageWithAttachments$1() {
        super(1);
    }

    public final void invoke(Message message) {
        Intrinsics.checkNotNullParameter(message, "$receiver");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Message) obj);
        return Unit.INSTANCE;
    }
}
