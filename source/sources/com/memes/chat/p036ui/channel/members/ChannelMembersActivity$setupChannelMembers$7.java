package com.memes.chat.p036ui.channel.members;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "channelMemberId", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersActivity$setupChannelMembers$7 */
/* compiled from: ChannelMembersActivity.kt */
final class ChannelMembersActivity$setupChannelMembers$7<T> implements Observer<String> {
    final /* synthetic */ ChannelMembersActivity this$0;

    ChannelMembersActivity$setupChannelMembers$7(ChannelMembersActivity channelMembersActivity) {
        this.this$0 = channelMembersActivity;
    }

    public final void onChanged(String str) {
        ChannelMembersAdapter access$getChannelMembersAdapter$p = this.this$0.getChannelMembersAdapter();
        Intrinsics.checkNotNullExpressionValue(str, "channelMemberId");
        access$getChannelMembersAdapter$p.removeChannelMemberById(str);
    }
}
