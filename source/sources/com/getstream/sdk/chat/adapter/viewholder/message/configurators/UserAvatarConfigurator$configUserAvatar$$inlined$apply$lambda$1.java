package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.view.View;
import com.getstream.sdk.chat.adapter.MessageListItem;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/getstream/sdk/chat/adapter/viewholder/message/configurators/UserAvatarConfigurator$configUserAvatar$1$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: UserAvatarConfigurator.kt */
final class UserAvatarConfigurator$configUserAvatar$$inlined$apply$lambda$1 implements View.OnClickListener {
    final /* synthetic */ Message $message$inlined;
    final /* synthetic */ MessageListItem.MessageItem $messageItem$inlined;
    final /* synthetic */ UserAvatarConfigurator this$0;

    UserAvatarConfigurator$configUserAvatar$$inlined$apply$lambda$1(UserAvatarConfigurator userAvatarConfigurator, MessageListItem.MessageItem messageItem, Message message) {
        this.this$0 = userAvatarConfigurator;
        this.$messageItem$inlined = messageItem;
        this.$message$inlined = message;
    }

    public final void onClick(View view) {
        this.this$0.userClickListener.onUserClick(this.$message$inlined.getUser());
    }
}
