package com.memes.chat.p036ui.channel.members;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersActivity$channelMembersAdapter$2 */
/* compiled from: ChannelMembersActivity.kt */
final class ChannelMembersActivity$channelMembersAdapter$2 extends Lambda implements Function0<ChannelMembersAdapter> {
    final /* synthetic */ ChannelMembersActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelMembersActivity$channelMembersAdapter$2(ChannelMembersActivity channelMembersActivity) {
        super(0);
        this.this$0 = channelMembersActivity;
    }

    public final ChannelMembersAdapter invoke() {
        ChannelMembersActivity channelMembersActivity = this.this$0;
        return new ChannelMembersAdapter(channelMembersActivity, channelMembersActivity);
    }
}
