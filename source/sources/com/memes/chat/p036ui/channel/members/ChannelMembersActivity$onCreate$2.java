package com.memes.chat.p036ui.channel.members;

import android.view.View;
import com.memes.chat.routing.ChatRouting;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersActivity$onCreate$2 */
/* compiled from: ChannelMembersActivity.kt */
final class ChannelMembersActivity$onCreate$2 implements View.OnClickListener {
    final /* synthetic */ ChannelMembersActivity this$0;

    ChannelMembersActivity$onCreate$2(ChannelMembersActivity channelMembersActivity) {
        this.this$0 = channelMembersActivity;
    }

    public final void onClick(View view) {
        ChatRouting chatRouting = ChatRouting.INSTANCE;
        ChannelMembersActivity channelMembersActivity = this.this$0;
        this.this$0.startActivityForResult(chatRouting.getAddChannelMembersIntent(channelMembersActivity, ChannelMembersActivity.access$getChannelId$p(channelMembersActivity)), 46545);
    }
}
