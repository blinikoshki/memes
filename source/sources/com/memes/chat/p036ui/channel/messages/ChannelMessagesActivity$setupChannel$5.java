package com.memes.chat.p036ui.channel.messages;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "message", "Lio/getstream/chat/android/client/models/Message;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.messages.ChannelMessagesActivity$setupChannel$5 */
/* compiled from: ChannelMessagesActivity.kt */
final class ChannelMessagesActivity$setupChannel$5 extends Lambda implements Function1<Message, Unit> {
    final /* synthetic */ ChannelMessagesActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelMessagesActivity$setupChannel$5(ChannelMessagesActivity channelMessagesActivity) {
        super(1);
        this.this$0 = channelMessagesActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Message) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.this$0.getMessageInputViewModel().getEditMessage().postValue(message);
    }
}
