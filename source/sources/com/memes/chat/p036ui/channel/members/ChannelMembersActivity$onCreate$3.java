package com.memes.chat.p036ui.channel.members;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "onRefresh"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersActivity$onCreate$3 */
/* compiled from: ChannelMembersActivity.kt */
final class ChannelMembersActivity$onCreate$3 implements SwipeRefreshLayout.OnRefreshListener {
    final /* synthetic */ ChannelMembersActivity this$0;

    ChannelMembersActivity$onCreate$3(ChannelMembersActivity channelMembersActivity) {
        this.this$0 = channelMembersActivity;
    }

    public final void onRefresh() {
        this.this$0.getChannelMembersViewModel().refreshChannelMembers();
    }
}
