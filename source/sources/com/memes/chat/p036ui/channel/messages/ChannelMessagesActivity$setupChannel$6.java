package com.memes.chat.p036ui.channel.messages;

import androidx.fragment.app.FragmentManager;
import com.getstream.sdk.chat.view.MessageListView;
import com.memes.chat.p036ui.channel.members.options.UserActionsBottomSheet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "user", "Lio/getstream/chat/android/client/models/User;", "onUserClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.messages.ChannelMessagesActivity$setupChannel$6 */
/* compiled from: ChannelMessagesActivity.kt */
final class ChannelMessagesActivity$setupChannel$6 implements MessageListView.UserClickListener {
    final /* synthetic */ ChannelMessagesActivity this$0;

    ChannelMessagesActivity$setupChannel$6(ChannelMessagesActivity channelMessagesActivity) {
        this.this$0 = channelMessagesActivity;
    }

    public final void onUserClick(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        Channel value = this.this$0.getMessageListViewModel().getChannel().getValue();
        if (value != null) {
            UserActionsBottomSheet userActionsBottomSheet = new UserActionsBottomSheet();
            FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            userActionsBottomSheet.show(supportFragmentManager, user, value);
        }
    }
}
