package com.memes.chat.p036ui.channel.messages;

import com.getstream.sdk.chat.viewmodel.factory.ChannelViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/getstream/sdk/chat/viewmodel/factory/ChannelViewModelFactory;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.messages.ChannelMessagesActivity$channelViewModelFactory$2 */
/* compiled from: ChannelMessagesActivity.kt */
final class ChannelMessagesActivity$channelViewModelFactory$2 extends Lambda implements Function0<ChannelViewModelFactory> {
    final /* synthetic */ ChannelMessagesActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelMessagesActivity$channelViewModelFactory$2(ChannelMessagesActivity channelMessagesActivity) {
        super(0);
        this.this$0 = channelMessagesActivity;
    }

    public final ChannelViewModelFactory invoke() {
        return new ChannelViewModelFactory(this.this$0.getChannelId(), this.this$0.getFocusedMessageId());
    }
}
