package com.getstream.sdk.chat.view.messageinput;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Command;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/models/Command;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputView.kt */
final class MessageInputView$commandsAdapter$1 extends Lambda implements Function1<Command, Unit> {
    final /* synthetic */ MessageInputView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageInputView$commandsAdapter$1(MessageInputView messageInputView) {
        super(1);
        this.this$0 = messageInputView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Command) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Command command) {
        Intrinsics.checkNotNullParameter(command, "it");
        this.this$0.getMessageInputController().onCommandSelected$stream_chat_android_release(command);
    }
}
