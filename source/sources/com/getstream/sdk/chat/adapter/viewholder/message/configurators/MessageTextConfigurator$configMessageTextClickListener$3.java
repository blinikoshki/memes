package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import com.getstream.sdk.chat.ChatUI;
import com.getstream.sdk.chat.adapter.viewholder.message.ExtensionsKt;
import com.getstream.sdk.chat.navigation.destinations.WebLinkDestination;
import com.getstream.sdk.chat.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"com/getstream/sdk/chat/adapter/viewholder/message/configurators/MessageTextConfigurator$configMessageTextClickListener$3", "Lcom/getstream/sdk/chat/utils/Utils$TextViewLinkHandler;", "onLinkClick", "", "url", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageTextConfigurator.kt */
public final class MessageTextConfigurator$configMessageTextClickListener$3 extends Utils.TextViewLinkHandler {
    final /* synthetic */ Message $message;
    final /* synthetic */ MessageTextConfigurator this$0;

    MessageTextConfigurator$configMessageTextClickListener$3(MessageTextConfigurator messageTextConfigurator, Message message) {
        this.this$0 = messageTextConfigurator;
        this.$message = message;
    }

    public void onLinkClick(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        if (!ExtensionsKt.isDeleted(this.$message) && !ExtensionsKt.isFailed(this.$message)) {
            if (this.this$0.isLongClick) {
                this.this$0.isLongClick = false;
            } else {
                ChatUI.Companion.instance().getNavigator().navigate(new WebLinkDestination(str, this.this$0.context));
            }
        }
    }
}
