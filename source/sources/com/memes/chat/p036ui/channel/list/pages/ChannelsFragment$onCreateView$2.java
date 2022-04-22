package com.memes.chat.p036ui.channel.list.pages;

import com.getstream.sdk.chat.view.channels.ChannelListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "channel", "Lio/getstream/chat/android/client/models/Channel;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.pages.ChannelsFragment$onCreateView$2 */
/* compiled from: ChannelsFragment.kt */
final class ChannelsFragment$onCreateView$2 implements ChannelListView.ChannelClickListener {
    final /* synthetic */ ChannelsFragment this$0;

    ChannelsFragment$onCreateView$2(ChannelsFragment channelsFragment) {
        this.this$0 = channelsFragment;
    }

    public final void onClick(Channel channel) {
        ChannelsFragment channelsFragment = this.this$0;
        Intrinsics.checkNotNullExpressionValue(channel, "channel");
        channelsFragment.showChannelOptions(channel);
    }
}
