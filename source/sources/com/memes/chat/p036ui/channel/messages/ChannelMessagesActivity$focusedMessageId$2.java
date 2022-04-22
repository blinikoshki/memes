package com.memes.chat.p036ui.channel.messages;

import android.content.Intent;
import com.memes.chat.routing.ChatRouting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.messages.ChannelMessagesActivity$focusedMessageId$2 */
/* compiled from: ChannelMessagesActivity.kt */
final class ChannelMessagesActivity$focusedMessageId$2 extends Lambda implements Function0<String> {
    final /* synthetic */ ChannelMessagesActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelMessagesActivity$focusedMessageId$2(ChannelMessagesActivity channelMessagesActivity) {
        super(0);
        this.this$0 = channelMessagesActivity;
    }

    public final String invoke() {
        Intent intent = this.this$0.getIntent();
        if (intent != null) {
            return intent.getStringExtra(ChatRouting.EXTRA_MESSAGE_ID);
        }
        return null;
    }
}
