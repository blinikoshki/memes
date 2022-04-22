package com.getstream.sdk.chat.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "", "Lio/getstream/chat/android/client/models/Message;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.viewmodel.MessageInputViewModelBinding$bindView$1$sendToThreadWithAttachments$1 */
/* compiled from: MessageInputViewModelBinding.kt */
final class C1762x5dd06f35 extends Lambda implements Function1<Message, Unit> {
    final /* synthetic */ boolean $alsoSendToChannel;
    final /* synthetic */ Message $parentMessage;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1762x5dd06f35(Message message, boolean z) {
        super(1);
        this.$parentMessage = message;
        this.$alsoSendToChannel = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Message) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Message message) {
        Intrinsics.checkNotNullParameter(message, "$receiver");
        message.setParentId(this.$parentMessage.getId());
        message.setShowInChannel(this.$alsoSendToChannel);
    }
}
