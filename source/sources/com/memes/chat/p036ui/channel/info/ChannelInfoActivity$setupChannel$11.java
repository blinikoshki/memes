package com.memes.chat.p036ui.channel.info;

import androidx.lifecycle.Observer;
import com.memes.chat.p036ui.channel.members.ChannelMembersAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "memberId", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoActivity$setupChannel$11 */
/* compiled from: ChannelInfoActivity.kt */
final class ChannelInfoActivity$setupChannel$11<T> implements Observer<String> {
    final /* synthetic */ ChannelInfoActivity this$0;

    ChannelInfoActivity$setupChannel$11(ChannelInfoActivity channelInfoActivity) {
        this.this$0 = channelInfoActivity;
    }

    public final void onChanged(String str) {
        ChannelMembersAdapter access$getChannelMembersAdapter$p = this.this$0.getChannelMembersAdapter();
        Intrinsics.checkNotNullExpressionValue(str, "memberId");
        access$getChannelMembersAdapter$p.removeChannelMemberById(str);
    }
}
