package com.memes.chat.p036ui.channel.info;

import androidx.lifecycle.Observer;
import com.memes.chat.p036ui.channel.options.ChannelMuteStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "status", "Lcom/memes/chat/ui/channel/options/ChannelMuteStatus;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoActivity$setupChannel$4 */
/* compiled from: ChannelInfoActivity.kt */
final class ChannelInfoActivity$setupChannel$4<T> implements Observer<ChannelMuteStatus> {
    final /* synthetic */ ChannelInfoActivity this$0;

    ChannelInfoActivity$setupChannel$4(ChannelInfoActivity channelInfoActivity) {
        this.this$0 = channelInfoActivity;
    }

    public final void onChanged(ChannelMuteStatus channelMuteStatus) {
        ChannelInfoActivity channelInfoActivity = this.this$0;
        Intrinsics.checkNotNullExpressionValue(channelMuteStatus, "status");
        channelInfoActivity.handleChannelMuteStatus(channelMuteStatus);
    }
}
